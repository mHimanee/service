package com.products.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  PriceByCategoryRepository pricerepository;

  @Autowired
  ProductRepository repository;

  public Product getProduct(Long id) {
    Optional<Product> product = repository.findById(id);
    if (product.isPresent()) {
      Product productItem = product.get();
      populateChargesAndPricesForProduct(productItem);
      return productItem;
    } else {
      throw new ProductNotFoundException(id);
    }

  }

  public List<Product> getProducts() {
    List<Product> products = repository.findAll();
    populateChargesAndPricesForProducts(products);
    return products;
  }

  public Product saveProduct(Product newProduct) {
    Product mproduct = repository.save(newProduct);
    populateChargesAndPricesForProduct(mproduct);
    return mproduct;
  }

  public Product editProduct(Product newProduct, Long id) {
    Optional<Product> product = repository.findById(id);
    if (product.isPresent()) {
      // set values
      Product mproduct = repository.save(new Product(id, newProduct.getProductName(),
          newProduct.getProductType(), newProduct.getProductCategory(), newProduct.getBasePrice()));
      populateChargesAndPricesForProduct(mproduct);
      return mproduct;
    } else {
      throw new ProductNotFoundException(id);
    }

  }

  public void deleteProduct(Long id) {
    repository.deleteById(id);
  }


  public Double getDiscountedPrice(Double basePrice, Double discount) {
    return (discount / 100.00) * basePrice;
  }

  public Double getGST(Double basePrice, Double gst) {
    return (gst / 100.00) * basePrice;
  }

  public void populateChargesAndPricesForProduct(Product product) {
    // Setting Data for Charges
    Charges charges = new Charges();
    String category = product.getProductCategory();
    PriceByCategory priceByCategory = pricerepository.getReferenceById(category);
    Double gst = getGST(product.getBasePrice(), priceByCategory.getGST());
    charges.setGst(gst);
    charges.setDelivery(priceByCategory.getDeliveryCharge());
    product.setCharges(charges);

    // setting Discount price
    product.setDiscount(getDiscountedPrice(product.getBasePrice(), priceByCategory.getDiscount()));

    // final Price
    product.setFinalPrice(product.getBasePrice() - product.getDiscount()
        + priceByCategory.getDeliveryCharge() + product.getCharges().getGst());

  }

  public void populateChargesAndPricesForProducts(List<Product> productList) {
    for (Product product : productList) {
      populateChargesAndPricesForProduct(product);
    }
  }

}
