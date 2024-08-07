package com.spring.ecommerce.persistence.dao;

import com.spring.ecommerce.persistence.model.Category;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends Neo4jRepository<Category, Long> {
}
