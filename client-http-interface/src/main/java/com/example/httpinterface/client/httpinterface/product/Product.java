package com.example.httpinterface.client.httpinterface.product;

import lombok.Value;

@Value
public class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final String sku;
}
