package com.example.httpinterface.client.resttemplate;

import com.example.httpinterface.client.resttemplate.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ClientRestTemplateApplication implements CommandLineRunner {
    private final ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ClientRestTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
