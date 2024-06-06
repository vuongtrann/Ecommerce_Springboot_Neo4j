package com.spring.ecommerce.persistence.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node
public class Category {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private Integer id;
    private String name;
    @Relationship(type = "CATEGORIES", direction = Relationship.Direction.INCOMING)
    private List product;
}