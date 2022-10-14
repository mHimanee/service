/**
 * 
 */
package com.products.service.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

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
  private Double basePrice;
  @Transient
  private Double discount;
  @Transient
  private Charges charges;
  @Transient
  private Double finalPrice;


  public Product() {}

  public Product(String productName, String productType, String productCategory, Double basePrice) {
    this.productName = productName;
    this.productType = productType;
    this.productCategory = productCategory;
    this.basePrice = basePrice;
  }

  public Product(Long productID, String productName, String productType, String productCategory,
      Double basePrice) {
    super();
    this.productID = productID;
    this.productName = productName;
    this.productType = productType;
    this.productCategory = productCategory;
    this.basePrice = basePrice;
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

  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Charges getCharges() {
    return charges;
  }

  public void setCharges(Charges charges) {
    this.charges = charges;
  }

  public Double getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice(Double finalPrice) {
    this.finalPrice = finalPrice;
  }

  @Override
  public String toString() {
    return "Product [productID=" + productID + ", productName=" + productName + ", productType="
        + productType + ", productCategory=" + productCategory + ", productPrice=" + basePrice
        + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCategory, productID, productName, basePrice, productType);
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
        && Objects.equals(basePrice, other.basePrice)
        && Objects.equals(productType, other.productType);
  }


}
