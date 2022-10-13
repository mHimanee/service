package com.products.service;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
  private final ProductRepository repository;
  
  ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/products")
  List<Product> all() {
    return repository.findAll();
  }

  @GetMapping("/products/{id}")
  Product one(@PathVariable Long id) {

    return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
  }

  @PostMapping("/products")
  Product newEmployee(@RequestBody Product newProduct) {
    return repository.save(newProduct);
  }

  @PutMapping("/products/{id}")
  Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

    Optional<Product> product = repository.findById(id);
    if (product.isPresent()) {
      // set values
      return repository
          .save(new Product(id, newProduct.getProductName(), newProduct.getProductType(),
              newProduct.getProductCategory(), newProduct.getBasePrice()));
    } else {
      throw new ProductNotFoundException(id);
    }

  }

  @DeleteMapping("/products/{id}")
  void deleteProduct(@PathVariable Long id) {
    repository.deleteById(id);
  }



}
