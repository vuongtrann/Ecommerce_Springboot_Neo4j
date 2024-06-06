package com.spring.ecommerce.persistence.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node("Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private Integer id;
    private String name;
    private String imageURL;
    private String description;
    private Double price;
    private Integer ratting;
    private String evaluatting;
}
