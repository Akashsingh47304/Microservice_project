package com.Ak.product_service.controller;

import com.Ak.product_service.dto.ProductRequest;
import com.Ak.product_service.model.Product;
import com.Ak.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest){
        Product newProduct= productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.FOUND).body(allProducts);
    }
}
