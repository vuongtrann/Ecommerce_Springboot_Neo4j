package com.spring.ecommerce.persistence.dao;

import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends Neo4jRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
