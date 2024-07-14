package com.example.crud.controllers;

import com.example.crud.domain.product.CreateProduct;
import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity<String> getProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts.toString());
    };

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid CreateProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok("Product created");
    };

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id,@RequestBody @Valid CreateProduct data){
        Product product = repository.findById(id).orElseThrow();
        product.setName(data.name());
        product.setPrice(data.price());
        repository.save(product);
        return ResponseEntity.ok("Product updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.ok("Product deleted");
    }
};
