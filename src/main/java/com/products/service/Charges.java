package com.products.service;

import java.util.Objects;

public class Charges {
  private Double gst;
  private Double delivery;
  
 
  public Charges(Double gst, Double delivery) {
    this.gst = gst;
    this.delivery = delivery;
    
  }

  public Charges() {}

  public Double getGst() {
    return gst;
  }

  public void setGst(Double gst) {
    this.gst = gst;
  }

  public Double getDelivery() {
    return delivery;
  }

  public void setDelivery(Double delivery) {
    this.delivery = delivery;
  }

  @Override
  public int hashCode() {
    return Objects.hash(delivery, gst);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Charges other = (Charges) obj;
    return Objects.equals(delivery, other.delivery) && Objects.equals(gst, other.gst);
  }

}
