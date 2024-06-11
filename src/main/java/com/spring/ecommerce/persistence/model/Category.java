package com.spring.ecommerce.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.ecommerce.persistence.model.config.LongIDGenerator;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

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

   @Relationship(type = "HAS_PRODUCT", direction = Relationship.Direction.OUTGOING)
   private Product product;
}