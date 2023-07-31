package com.example.httpinterface.client.httpinterface.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductWebClientService {
    private final ProductWebClientDao productWebClientDao;

    public List<Product> fetchAllProducts() {
        return productWebClientDao.fetchAllProducts();
    }

    public Product createProduct(Product test) {
        return productWebClientDao.createProduct(test);
    }

    public Product fetchProductDetail(Long productId) {
        return productWebClientDao.fetchDetail(productId);
    }
}
