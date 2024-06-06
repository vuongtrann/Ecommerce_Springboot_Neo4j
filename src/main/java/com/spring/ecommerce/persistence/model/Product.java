package com.spring.ecommerce.persistence.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node
public class Product {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private Integer id;
    private String name;
    private String imageURL;
    private String description;
    private Double price;
    private Integer ratting;
    private String evaluatting;
}
