package com.example.httpinterface.client.resttemplate;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
//        builder.rootUri()
    }
}
