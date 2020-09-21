package com.jueshan.pulsar.client.config;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Pulsar JavaClient](https://pulsar.apache.org/docs/en/client-libraries-java/#client)
 */
@Configuration
public class PulsarClientConfig {

    @Value("${pulsar.url}")
    private String pulsarUrl;

    @Bean
    public PulsarClient getPulsarClient() throws PulsarClientException {
        return PulsarClient.builder()
                .serviceUrl(pulsarUrl)
                .build();
    }
}