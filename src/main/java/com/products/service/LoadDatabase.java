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
  CommandLineRunner initDatabase(ProductRepository repository) {

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
    };
  }

}
