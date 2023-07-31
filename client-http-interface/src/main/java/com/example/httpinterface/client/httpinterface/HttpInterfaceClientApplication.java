package com.example.httpinterface.client.httpinterface;

import com.example.httpinterface.client.httpinterface.product.Product;
import com.example.httpinterface.client.httpinterface.product.ProductService;
import com.example.httpinterface.client.httpinterface.product.ProductWebClientService;
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
public class HttpInterfaceClientApplication implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final ProductWebClientService productWebClientService;
    private final ProductService productService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(HttpInterfaceClientApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        final String methodName = "run";
        final Product test = new Product(null, "Another Test", "New test product created from WebClient", "0201");
        log.info("{}: creating testProduct={}", methodName, test);
        productWebClientService.createProduct(test);

        final List<Product> products = productWebClientService.fetchAllProducts();
        log.info("{}: products={}", methodName, products);

        final Product detail = productWebClientService.fetchProductDetail(1L);
        log.info("{}: detail={}", methodName, detail);

        log.info("========================= HttpInterface =========================");

        final Product secondTestProduct = new Product(null, "Third Test", "New test product created from HttpInterface", "0301");

        log.info("{}: creating new product={}", methodName, secondTestProduct);
        productService.createProduct(secondTestProduct);

        final List<Product> allProducts = productService.fetchAllProducts();
        log.info("{}: all products={}", methodName, allProducts);

        final Product productDetail = productService.fetchProductDetail(1L);
        log.info("{}: productDetail={}", methodName, productDetail);

    }
}
