package com.spring.ecommerce.persistence.model;


import com.spring.ecommerce.persistence.model.config.LongIDGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    @GeneratedValue( generatorClass = LongIDGenerator.class)
    private Long review_id;
    private String description;
    private int point;

    @Relationship(type = "Review_About", direction = Relationship.Direction.OUTGOING)
    private Product product;



}
