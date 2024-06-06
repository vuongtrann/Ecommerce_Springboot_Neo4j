package com.spring.ecommerce.persistence.dao;

import com.spring.ecommerce.persistence.model.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProductRepository extends Neo4jRepository<Product, Long> {
    Product findByName(String name);
}
