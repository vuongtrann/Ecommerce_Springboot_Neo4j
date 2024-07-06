package com.spring.ecommerce.persistence.dao;

import com.spring.ecommerce.persistence.model.Review;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends Neo4jRepository<Review, Long> {
}
