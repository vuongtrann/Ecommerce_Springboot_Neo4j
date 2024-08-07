package com.spring.ecommerce.persistence.model;

import com.spring.ecommerce.persistence.model.config.LongIDGenerator;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(generatorClass = LongIDGenerator.class)
    private Long id;
    private String name;
    private String imageURL;
    private String description;
    private Double price;
    private Double ratting;
    private String evaluatting;

    private Category category;


    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private Set <Category> CategoriesRelationship;

    public void addCategory(Category category) {
        if (CategoriesRelationship == null){
            CategoriesRelationship = new HashSet<>();
        }

        CategoriesRelationship.add(category);
    }

    @Relationship(type = "HAS_PRODUCT", direction = Relationship.Direction.OUTGOING)
    private Set <Category> hasProductCategory;

    public void addProductCategory(Category category) {
        if (hasProductCategory == null){
            hasProductCategory = new HashSet<>();
        }
        hasProductCategory.add(category);
    }



}
