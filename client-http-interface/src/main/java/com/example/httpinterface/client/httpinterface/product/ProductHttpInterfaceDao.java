package com.example.httpinterface.client.httpinterface.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("/api/products")
public interface ProductHttpInterfaceDao {
    @GetExchange
    List<Product> fetchAllProducts();

    @PostExchange
    Product createProduct(@RequestBody Product newProduct);

    @GetExchange("/{productId}")
    Product fetchProductDetail(@PathVariable("productId") long productId);

}
