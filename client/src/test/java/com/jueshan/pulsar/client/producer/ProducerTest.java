package com.jueshan.pulsar.client.producer;

import com.jueshan.pulsar.client.ExtractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProducerTest extends ExtractTest {

    public static final String TOPIC_NAME = "test-pulsar-topic";

    @Autowired
    private ProducerPulsar producer;

    @Test
    public void testProducer(){
        String message = "Hello Pulsar!!!";
        producer.sendMessage(TOPIC_NAME,message.getBytes());
    }
}