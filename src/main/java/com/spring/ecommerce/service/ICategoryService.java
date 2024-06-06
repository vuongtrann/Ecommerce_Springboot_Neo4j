package com.spring.ecommerce.service;


import com.spring.ecommerce.persistence.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    public List<Category> getAllCategories();
    public Optional<Category> getCategoryById(int id);
    public Optional<Category> getCategoryByName(String name);
    public Category save(Category category);
    public Category update(int catId ,Category category);
    public void deleteById(int id);
}
