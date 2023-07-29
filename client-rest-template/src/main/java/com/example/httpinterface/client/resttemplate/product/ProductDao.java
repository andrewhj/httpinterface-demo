package com.example.httpinterface.client.resttemplate.product;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class ProductDao {
    private final RestTemplate restTemplate;

    public List<Product> fetchAllProducts() {
        final ResponseEntity<ProductList> response = restTemplate.exchange("/api/products", HttpMethod.GET, null, ProductList.class);
        return Objects.requireNonNull(response.getBody()).getProducts();
    }


}
