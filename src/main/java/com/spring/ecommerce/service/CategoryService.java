package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save( category);
    }

    @Override
    public Category saveWithOthersCate( Category category, Long categoryID) {
        Optional<Category> otherCategory = categoryRepository.findById(categoryID);
        if (otherCategory.isPresent()) {
           category.addBelongCategory(otherCategory.get());
            categoryRepository.save(category);
        }

        return category;
    }


    @Override
    public List<Category> saveAll(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }


    @Override
    public Category update(Long categoryID, Category category) {

            Optional<Category> updatedCategory = categoryRepository.findById(categoryID);
            if (updatedCategory.isPresent()) {
                updatedCategory.get().setName(category.getName());
                return categoryRepository.save(updatedCategory.get());
            }
            else {

                return null;
            }



    }



    @Override
    public Category deleteById(Long id) {
        try {
            Optional<Category> category = categoryRepository.findById(id);
            if (category.isPresent()) {

                categoryRepository.deleteById(id);
            }
            return category.get();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }








}
