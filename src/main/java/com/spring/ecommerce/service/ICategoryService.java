package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    public List<Category> findAll();
    public Optional<Category> findById(int id);
    public Optional<Category> findByName(String name);
    public Category save(Category category);
    public Product save(Product product);
    public void deleteById(int id);
}
