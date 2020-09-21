package com.jueshan.pulsar.client.consumer;

import com.jueshan.pulsar.client.ExtractTest;
import org.apache.pulsar.client.api.PulsarClientException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jueshan.pulsar.client.producer.ProducerTest.TOPIC_NAME;

public class ConsumerTest extends ExtractTest {

    @Autowired
    private PulsarConsumer pulsarConsumer;

    @Test
    public void testConsumer(){
        try {
            pulsarConsumer.receiveMessage(TOPIC_NAME);
        } catch (PulsarClientException e){
            e.printStackTrace();
        }
    }
}