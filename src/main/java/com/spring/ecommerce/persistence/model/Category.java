package com.spring.ecommerce.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.model.config.LongIDGenerator;
import com.spring.ecommerce.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.*;

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


    @JsonIgnore
    @Relationship(type = "BELONG_TO", direction = Relationship.Direction.OUTGOING)
    Set<Category> reCategory = new HashSet<Category>();




//    @Relationship(type = "HAS_PRODUCT", direction = Relationship.Direction.OUTGOING)
//    Set<Product> ReProduct = new HashSet<Product>();





    public void addBelongCategory(Category category) {
        if (reCategory == null) {
            reCategory = new HashSet<>();
        }
        reCategory.add(category);

    }

//    public void addProduct(Product product) {
//        if (ReProduct == null) {
//            ReProduct = new HashSet<>();
//        }
//
//        ReProduct.add(product);
//    }




}