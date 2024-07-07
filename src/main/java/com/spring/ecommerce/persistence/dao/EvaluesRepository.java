package com.spring.ecommerce.persistence.dao;

import com.spring.ecommerce.persistence.model.Evalues;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluesRepository extends Neo4jRepository<Evalues, Long> {
}
