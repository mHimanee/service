package com.products.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.products.service.models.PriceByCategory;

@Repository
public interface PriceByCategoryRepository extends JpaRepository<PriceByCategory, String> {

}
