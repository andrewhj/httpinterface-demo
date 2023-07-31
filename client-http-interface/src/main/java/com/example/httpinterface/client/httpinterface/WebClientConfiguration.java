package com.example.httpinterface.client.httpinterface;

import com.example.httpinterface.client.httpinterface.product.ProductHttpInterfaceDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfiguration {
    @Bean
    public WebClient webClient(WebClient.Builder builder, @Value(value = "${demo.server.base-uri}") String baseUri) {
        return builder
                .baseUrl(baseUri)
                .build();
    }

    // needed to setup the HttpInterface, not required for WebClient only approach

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory(WebClient webClient) {
        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
    }

    @Bean
    public ProductHttpInterfaceDao productHttpInterfaceDao(HttpServiceProxyFactory factory) {
        return factory.createClient(ProductHttpInterfaceDao.class);
    }
}
