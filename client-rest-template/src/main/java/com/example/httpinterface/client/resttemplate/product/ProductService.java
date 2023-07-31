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

    public Product createProduct(Product newProduct) {
        return productDao.create(newProduct);
    }

    public Product fetchProductDetail(Long productId) {
        return productDao.fetchDetail(productId);
    }
}
