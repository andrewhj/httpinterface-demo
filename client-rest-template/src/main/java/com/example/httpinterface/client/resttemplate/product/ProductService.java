package com.example.httpinterface.client.resttemplate.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductDao productDao;

    public List<Product> fetchAllProducts() {
        return productDao.fetchAllProducts();
    }
}
