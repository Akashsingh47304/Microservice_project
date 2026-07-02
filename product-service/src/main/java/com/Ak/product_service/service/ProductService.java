package com.Ak.product_service.service;

import com.Ak.product_service.dto.ProductRequest;
import com.Ak.product_service.model.Product;
import com.Ak.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest){
        Product savedProject= productRepository.save(toProduct(productRequest));
        log.info("product is saved");
        return savedProject;


    }

    private Product toProduct(ProductRequest productRequest) {
        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        return newProduct;
    }

    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }
}
