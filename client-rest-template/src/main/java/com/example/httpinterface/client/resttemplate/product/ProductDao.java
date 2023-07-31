package com.example.httpinterface.client.resttemplate.product;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductDao {
    private final RestTemplate restTemplate;

    public List<Product> fetchAllProducts() {
        final UriComponents uriComponents = UriComponentsBuilder.fromPath("/api/products")
                .build();
        final ResponseEntity<Product[]> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, null, Product[].class);
        return Arrays.stream(Objects.requireNonNull(response.getBody())).collect(Collectors.toList());
    }

    public Product create(Product newProduct) {
        final UriComponents uriComponents = UriComponentsBuilder.fromPath("/api/products")
                .build();
        final HttpEntity<Product> request = new HttpEntity<>(newProduct);
        final ResponseEntity<Product> product = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.POST, request, Product.class);
        return product.getBody();
    }

    public Product fetchDetail(Long productId) {
        UriTemplate uriTemplate = new UriTemplate("/api/products/{productId}");
        final Object[] templateVariables = {productId};
        final URI uri = uriTemplate.expand(templateVariables);
        final ResponseEntity<Product> response = restTemplate.exchange(uri.toString(), HttpMethod.GET, null, Product.class);
        return response.getBody();
    }
}
