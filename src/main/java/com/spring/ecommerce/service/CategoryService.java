package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Category update(int catId, Category category) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
