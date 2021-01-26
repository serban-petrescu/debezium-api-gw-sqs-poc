package io.debezium.examples.demo;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import io.debezium.config.Configuration;
import io.debezium.embedded.EmbeddedEngine;
import io.debezium.examples.demo.apigw.DemoService;
import io.debezium.examples.demo.apigw.model.DebezmodelM5EUNDJ1BWH9;
import io.debezium.examples.demo.apigw.model.PostTenantsTenantRequest;
import io.debezium.util.Clock;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.json.JsonConverter;
import org.apache.kafka.connect.source.SourceRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Demo for using the Debezium Embedded API to send change events to Amazon API GW.
 */
public class ChangeDataSender implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeDataSender.class);
    private static final String APP_NAME = "demo";

    private final Configuration config;
    private final JsonConverter valueConverter;
    private final DemoService demoService;
    private EmbeddedEngine engine;

    public ChangeDataSender() {
        config = Configuration.empty().withSystemProperties(Function.identity()).edit()
                .with(EmbeddedEngine.CONNECTOR_CLASS, "io.debezium.connector.simple.SimpleSourceConnector")
                .with(EmbeddedEngine.ENGINE_NAME, APP_NAME)
                .with(EmbeddedEngine.OFFSET_STORAGE, "org.apache.kafka.connect.storage.MemoryOffsetBackingStore")
                .with("batch.count", "1")
                .build();

        valueConverter = new JsonConverter();
        valueConverter.configure(config.asMap(), false);

        demoService = DemoService.builder()
                .iamCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .endpoint("https://8dn7h7f45e.execute-api.us-east-1.amazonaws.com")
                .build();
    }

    @Override
    public void run() {
        engine = EmbeddedEngine.create()
                .using(config)
                .using(this.getClass().getClassLoader())
                .using(Clock.SYSTEM)
                .notifying(this::sendRecord)
                .build();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(engine);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("Requesting embedded engine to shut down");
            engine.stop();
        }));

        // the submitted task keeps running, only no more new ones can be added
        executor.shutdown();

        awaitTermination(executor);

        cleanUp();

        LOGGER.info("Engine terminated");
    }

    private void awaitTermination(ExecutorService executor) {
        try {
            while (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                LOGGER.info("Waiting another 10 seconds for the embedded engine to complete");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void cleanUp() {
        demoService.shutdown();
    }

    private void sendRecord(SourceRecord record) {
        Schema schema = null;

        if (null == record.keySchema()) {
            LOGGER.error("The keySchema is missing. Something is wrong.");
            return;
        }

        // For deletes, the value node is null
        if (null != record.valueSchema()) {
            schema = SchemaBuilder.struct()
                    .field("key", record.keySchema())
                    .field("value", record.valueSchema())
                    .build();
        } else {
            schema = SchemaBuilder.struct()
                    .field("key", record.keySchema())
                    .build();
        }

        Struct message = new Struct(schema);
        message.put("key", record.key());

        if (null != record.value())
            message.put("value", record.value());

        final byte[] payload = valueConverter.fromConnectData("dummy", schema, message);
        demoService.postTenantsTenant(
                new PostTenantsTenantRequest()
                        .tenant("A") // changing to "B" should break the program if the AWS IAM debezium-role is used.
                        .debezmodelM5EUNDJ1BWH9(new DebezmodelM5EUNDJ1BWH9().data(new String(payload)))
        );
        LOGGER.info("Sent message to API GW.");
    }

    public static void main(String[] args) {
        new ChangeDataSender().run();
    }
}
