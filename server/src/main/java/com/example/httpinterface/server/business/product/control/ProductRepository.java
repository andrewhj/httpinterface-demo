package com.example.httpinterface.server.business.product.control;

import com.example.httpinterface.server.business.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
