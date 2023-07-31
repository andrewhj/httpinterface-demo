package com.example.httpinterface.client.httpinterface.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductHttpInterfaceDao productDao;

    public List<Product> fetchAllProducts() {
        return productDao.fetchAllProducts();
    }

    public Product fetchProductDetail(Long productId) {
        return productDao.fetchProductDetail(productId);
    }

    public Product createProduct(Product newProduct) {
        return productDao.createProduct(newProduct);
    }
}
