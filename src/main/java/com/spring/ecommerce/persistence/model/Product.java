package com.spring.ecommerce.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private Set <Category> reCategory;





    public void addCategory(Category category) {
        if (reCategory == null){
            reCategory = new HashSet<>();
        }
        reCategory.add(category);
    }

    public void update ( Product product){
        this.setName(product.getName());
        this.setImageURL(product.getImageURL());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setRatting(product.getRatting());

    }



}
