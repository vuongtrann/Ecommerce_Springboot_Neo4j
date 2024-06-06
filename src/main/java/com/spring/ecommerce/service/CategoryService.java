package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.dao.ProductRepository;
import com.spring.ecommerce.persistence.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> getCategoryByName(String name) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public Category update(int catId, Category category) {
        Category updatedCategory = categoryRepository.findById(catId).orElseThrow();
        updatedCategory.setName(category.getName());
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public void deleteById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }
}
