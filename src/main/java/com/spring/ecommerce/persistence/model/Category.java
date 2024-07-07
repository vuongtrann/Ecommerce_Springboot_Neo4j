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

    @Relationship(type = "HAS_PRODUCT", direction = Relationship.Direction.OUTGOING)
    Set<Product> products_relationship = new HashSet<Product>();

<<<<<<< HEAD


=======
    public Long getId() {
        return id;
    }
>>>>>>> cb9aaa9c30d15f55d1ada0d7a8b78ef7b9494f21
    /** Improve*/

    Set<Long> hasCategoryID = new HashSet<Long>();
    Set<Long> belongToCategoryID = new HashSet<Long>();

    public void addHasCategoryID(Category category) {
        hasCategoryID.add(category.getId());
        addHasCategory(category);
    }
    public void deleteHasCategoryID(Category category) {
        hasCategoryID.remove(category.getId());
        hasCategory.remove(category);
    }
    public void addBelongToCategoryID(Category savedCategory) {
        belongToCategoryID.add(savedCategory.getId());
        addBelongCategory(savedCategory);
    }
    @JsonIgnore
    @Relationship(type = "HAS_CATEGORY", direction = Relationship.Direction.OUTGOING)
      Set<Category> hasCategory = new HashSet<Category>();

    public void addHasCategory(Category category) {
        if (hasCategory == null) {
            hasCategory = new HashSet<>();
        }
        hasCategory.add(category);
    }
    @JsonIgnore
    @Relationship(type = "BELONG_TO", direction = Relationship.Direction.OUTGOING)
    Set<Category> belongToCategory = new HashSet<Category>();

    public void addBelongCategory(Category category) {
        if (belongToCategory == null) {
            belongToCategory = new HashSet<>();
        }
        belongToCategory.add(category);

    }
    public void addProduct(Product product) {
        if (products_relationship == null) {
            products_relationship = new HashSet<>();
        }

        products_relationship.add(product);
    }



<<<<<<< HEAD
=======
/**
 * Test ok
 */

//    @Relationship(type = "HAS_CATEGORY", direction = Relationship.Direction.INCOMING)
//    Set<Category> hasCategory = new HashSet<Category>();
//
//    public void addHasCategory(Category category) {
//        if (hasCategory == null) {
//            hasCategory = new HashSet<>();
//        }
//
//        hasCategory.add(category);
//
//    }
//
//
//    @Relationship(type = "BELONG_TO", direction = Relationship.Direction.INCOMING)
//    Set<Category> belongToCategory = new HashSet<Category>();
//
//    public void addBelongCategory(Category category) {
//        if (belongToCategory == null) {
//            belongToCategory = new HashSet<>();
//        }
//
//        belongToCategory.add(category);
//
//    }

//    public void addProduct(Product product) {
//        if (products_relationship == null) {
//            products_relationship = new HashSet<>();
//        }
//
//        products_relationship.add(product);
//    }



>>>>>>> cb9aaa9c30d15f55d1ada0d7a8b78ef7b9494f21

}