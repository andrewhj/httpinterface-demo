package com.example.httpinterface.client.httpinterface.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductWebClientDao {
    private static final String PRODUCT_PATH = "/api/products";

    private final WebClient webClient;

    public List<Product> fetchAllProducts() {
        return webClient.get()
                .uri(PRODUCT_PATH)
                .exchangeToFlux(resp -> resp.bodyToFlux(Product.class))
                .log()
                .collectList()
                .block();
    }

    public Product createProduct(Product test) {
        return webClient.post()
                .uri(PRODUCT_PATH)
                .body(Mono.just(test), Product.class)
                .exchangeToMono(r -> r.bodyToMono(Product.class))
                .block();
    }

    public Product fetchDetail(Long productId) {
        return webClient.get()
                .uri("/api/products/{productId}", productId)
                .exchangeToMono(r -> r.bodyToMono(Product.class))
                .block();
    }
}
