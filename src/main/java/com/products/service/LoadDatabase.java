package com.products.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ProductRepository repository, PriceByCategoryRepository pricerepository) {

    return args -> {
      log.info("Preloading "
          + repository.save(new Product("Lenovo Yoga", "Laptop", "Electronics", 45000.00)));
      log.info("Preloading " + repository
          .save(new Product("LG Washing Machine", "Washing Machine", "Home Appliances", 25000.00)));
      log.info("Preloading "
          + repository.save(new Product("HP Pavilion 360", "Laptop", "Electronics", 60000.00)));
      log.info("Preloading "
          + repository.save(new Product("US Polo Assn", "T-Shirt", "Clothing", 1200.00)));
      log.info("Preloading "
          + repository.save(new Product("Neelkamal Been Bag", "Sofa Set", "Furniture", 350.00)));
      log.info("Preloading "
          + pricerepository.save(new PriceByCategory("Electronics",350.00,0.15,0.18)));
      log.info("Preloading "
          + pricerepository.save(new PriceByCategory("Home Appliances",800.00,0.22,0.24)));
      log.info("Preloading "
          + pricerepository.save(new PriceByCategory("Clothing", 0.0,0.40,0.12)));
      log.info("Preloading "
          + pricerepository.save(new PriceByCategory("Furniture",300.00,0.10,0.18)));
          
    };
  }
   

}
