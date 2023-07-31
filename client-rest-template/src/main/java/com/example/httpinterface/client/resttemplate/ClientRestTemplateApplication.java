package com.example.httpinterface.client.resttemplate;

import com.example.httpinterface.client.resttemplate.product.Product;
import com.example.httpinterface.client.resttemplate.product.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class ClientRestTemplateApplication implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ProductService productService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(ClientRestTemplateApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        final Product test = new Product(null, "Test", "New test product created from RestTemplate client", "0101");

        log.info("run: creating testProduct={}", test);
        productService.createProduct(test);

        final List<Product> products = productService.fetchAllProducts();

        log.info("run: products={}", products);


        final Product firstProduct = productService.fetchProductDetail(1L);
        log.info("run: firstProduct={}", firstProduct);
    }
}
