package com.spring.ecommerce.service;


import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    public List<Category> findAll();
    public Optional<Category> findById(Long id);
    public Optional<Category> findByName(String name);
    public Category save(Category category);
    public Category saveWithOthersCate(Category category, Long categoryID);

    public List<Category> saveAll(List<Category> categories);
    public Category update(Long categoryID, Category category);
    public Category deleteById(Long id);
    public Product addProduct(Long categoryId, Product newProduct);



}
