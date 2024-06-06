package com.spring.ecommerce.persistence.model;

import com.spring.ecommerce.persistence.model.config.LongIDGenerator;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue( generatorClass = LongIDGenerator.class)
    private Long id;
    private String name;

//    @Relationship(type = "CATEGORIES", direction = Relationship.Direction.INCOMING)
//    private List product;
}