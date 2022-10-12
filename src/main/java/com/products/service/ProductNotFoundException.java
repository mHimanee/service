package com.products.service;

public class ProductNotFoundException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 2445516349177140715L;

  ProductNotFoundException(Long id) {
    super("Product Not Found Corresponding To ID: " + id);
  }
}
