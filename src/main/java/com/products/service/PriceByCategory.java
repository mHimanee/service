package com.products.service;

import java.util.Objects;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Himanee
 *
 */
@Entity
public class PriceByCategory {
	private @Id String productCategory;
	private Double deliveryCharge;
	private Double discount;
	private Double GST;
	//private Double productPrice;
	
	public PriceByCategory() {}

	public PriceByCategory(Double deliveryCharge, Double discount, Double GST) {
	    //this.productCategory = productCategory;
	    this.deliveryCharge = deliveryCharge;
	    this.discount = discount;
	    this.GST = GST;
	    //this.productPrice = productPrice;
	  }

	  public PriceByCategory(String productCategory, Double deliveryCharge, Double discount, Double GST) {
	    super();
	    this.productCategory = productCategory;
	    this.deliveryCharge = deliveryCharge;
	    this.discount = discount;
	    this.GST = GST;
	    //this.productPrice = productPrice;
	  }
	  
	  public String getProductCategory() {
		    return productCategory;
		  }

	  public void setProductCategory(String productCategory) {
		    this.productCategory = productCategory;
		  }	  
	  
	  public Double getDeliveryCharge() {
		    return deliveryCharge;
		  }

	  public void setDeliveryCharge(Double deliveryCharge) {
		    this.deliveryCharge = deliveryCharge;
		  }
		  
	  public Double getDiscount() {
			    return discount;
		  }

	  public void setDiscount(Double discount) {
			    this.discount = discount;
		}
	  
	  public Double getGST() {
		    return GST;
		  }

	  public void setGST(Double GST) {
		    this.GST = GST;
		  }
	  
	  /*public Double getProductPrice() {
		    return productPrice;
		  }

	  public void setProductPrice(Double productPrice) {
		    this.productPrice = productPrice;
		  }*/
	  
	  @Override
	  public String toString() {
	    return "PriceByCategory [productCategory=" + productCategory + ", deliveryCharge=" + deliveryCharge + ", discount="
	        + discount + ", GST=" + GST + "]";
	  }
	  
	  @Override
	  public int hashCode() {
	    return Objects.hash(productCategory,deliveryCharge, discount, GST);
	  }

	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    PriceByCategory other = (PriceByCategory) obj;
	    return Objects.equals(productCategory, other.productCategory)
	        && Objects.equals(deliveryCharge, other.deliveryCharge)
	        && Objects.equals(discount, other.discount)
	        && Objects.equals(GST, other.GST);
	       // && Objects.equals(productPrice, other.productPrice);
	        
	  }
}
