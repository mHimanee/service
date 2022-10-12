/**
 * 
 */
package com.products.service;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Himanee
 *
 */
@Entity
public class Product {
  private @Id @GeneratedValue Long productID;
  private String productName;
  private String productType;
  private String productCategory;
  private Double productPrice;

  public Product() {}

  public Product(String productName, String productType, String productCategory,
      Double productPrice) {
    this.productName = productName;
    this.productType = productType;
    this.productCategory = productCategory;
    this.productPrice = productPrice;
  }

  public Product(Long productID, String productName, String productType, String productCategory,
      Double productPrice) {
    super();
    this.productID = productID;
    this.productName = productName;
    this.productType = productType;
    this.productCategory = productCategory;
    this.productPrice = productPrice;
  }

  public Long getProductID() {
    return productID;
  }

  public void setProductID(Long productID) {
    this.productID = productID;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }

  public Double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }

  @Override
  public String toString() {
    return "Product [productID=" + productID + ", productName=" + productName + ", productType="
        + productType + ", productCategory=" + productCategory + ", productPrice=" + productPrice
        + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCategory, productID, productName, productPrice, productType);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    return Objects.equals(productCategory, other.productCategory)
        && Objects.equals(productID, other.productID)
        && Objects.equals(productName, other.productName)
        && Objects.equals(productPrice, other.productPrice)
        && Objects.equals(productType, other.productType);
  }


}
