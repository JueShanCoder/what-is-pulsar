package com.jueshan.pulsar.client.producer;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Service;

/**
 * [Pulsar Producer](https://pulsar.apache.org/docs/en/client-libraries-java/#producer)
 */
@Service
public class ProducerPulsar {

    private final PulsarClient pulsarClient;

    public ProducerPulsar(PulsarClient pulsarClient) {
        this.pulsarClient = pulsarClient;
    }

    public void sendMessage(String topic,byte[] message){
        try {
            pulsarClient.newProducer()
                    .topic(topic)
                    .create();
        } catch (PulsarClientException e){
            e.printStackTrace();
        }
    }
}