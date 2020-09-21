package com.jueshan.pulsar.client.consumer;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Service;

/**
 * [Pulsar Consumer](https://pulsar.apache.org/docs/en/client-libraries-java/#consumer)
 */
@Service
public class PulsarConsumer {

    private final PulsarClient pulsarClient;

    public PulsarConsumer(PulsarClient pulsarClient) {
        this.pulsarClient = pulsarClient;
    }

    public void receiveMessage(String topicName) throws PulsarClientException {
        Consumer<byte[]> consumer = pulsarClient.newConsumer()
                .topic(topicName)
                .subscriptionName(topicName)
                .subscribe();

        for(;;) {
            // Wait for a message
            Message msg = consumer.receive();
            try {
                // Do something with the message
                System.out.printf("Message received: %s", new String(msg.getData()));
                // Acknowledge the message so that it can be deleted by the message broker
                consumer.acknowledge(msg);
            } catch (Exception e) {
                // Message failed to process, redeliver later
                consumer.negativeAcknowledge(msg);
            }
        }
    }

    public void closeConsumer(Consumer consumer) throws PulsarClientException {
        consumer.close();
    }
}