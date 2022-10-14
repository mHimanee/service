package com.products.service.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.products.service.ProductService;
import com.products.service.models.Product;
import com.products.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ProductController {
  private final ProductRepository repository;

  ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  @Autowired
  ProductService productservice;

  @GetMapping("/products")
  List<Product> all() {
    return productservice.getProducts();
  }

  @GetMapping("/products/{id}")
  Product one(@PathVariable Long id) {
    return productservice.getProduct(id);
  }

  @PostMapping("/products")
  Product newEmployee(@RequestBody Product newProduct) {
    return productservice.saveProduct(newProduct);
  }

  @PutMapping("/products/{id}")
  Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
    return productservice.editProduct(newProduct, id);
  }

  @DeleteMapping("/products/{id}")
  void deleteProduct(@PathVariable Long id) {
    productservice.deleteProduct(id);
  }



}
