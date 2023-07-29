package com.example.httpinterface.server.business.product.boundary;

import com.example.httpinterface.server.business.product.control.ProductRepository;
import com.example.httpinterface.server.business.product.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/products")
@AllArgsConstructor
public class ProductEndpoint {
    private final ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> allProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        final Product savedProduct = productRepository.save(newProduct);
        return ResponseEntity.ofNullable(savedProduct);
    }
}
