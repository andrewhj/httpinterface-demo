package com.example.httpinterface.client.resttemplate.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProductList {
    private final List<Product> products;

    protected ProductList() {
        this(null);
    }
}
