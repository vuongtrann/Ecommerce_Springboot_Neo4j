package com.spring.ecommerce.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.ecommerce.persistence.model.config.LongIDGenerator;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node("Category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(generatorClass = LongIDGenerator.class)
    private Long id;
    private String name;

    @Relationship(type = "HAS_PRODUCT", direction = Relationship.Direction.OUTGOING)
    Set<Product> products_relationship = new HashSet<Product>();


    @Relationship(type = "HAS_CATEGORY", direction = Relationship.Direction.OUTGOING)
    Set<Category> category_relationship = new HashSet<Category>();










    public void addProduct(Product product) {
        if (products_relationship == null) {
            products_relationship = new HashSet<>();
        }

        products_relationship.add(product);
    }


    public void addOrtherCategory(Category category) {
        if (category_relationship == null) {
            category_relationship = new HashSet<>();
        }

        category_relationship.add(category);

    }

}