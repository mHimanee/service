package com.products.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceByCategoryRepository extends JpaRepository<PriceByCategory, String> {

}
