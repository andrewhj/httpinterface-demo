package com.example.httpinterface.client.resttemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder, @Value(value = "${demo.server.base-uri}") String baseUri) {
        final DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory(baseUri);
        return builder
                .rootUri(baseUri)
                .uriTemplateHandler(defaultUriBuilderFactory)
                .build();
    }
}
