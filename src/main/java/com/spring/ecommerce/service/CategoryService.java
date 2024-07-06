package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.dao.ProductRepository;
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
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> getCategoryByName(String name) {
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
            Category savedCategory = otherCategory.get();
            category.addBelongToCategoryID(savedCategory);
            category= categoryRepository.save(category);
            savedCategory.addHasCategoryID(category);
            categoryRepository.save(savedCategory);
        }
        return category;
    }


    @Override
    public List<Category> saveAll(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }


    @Override
    public Category update(Long catId, Category category) {
        Category updatedCategory = categoryRepository.findById(catId).orElseThrow();
        updatedCategory.setName(category.getName());
        return categoryRepository.save(updatedCategory);
    }




    @Override
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();

        if (category.getHasCategoryID()!= null){
            for (Long idCate : category.getHasCategoryID()) {
                Optional<Category> cate=getCategoryById(id);
                cate.ifPresent(value -> value.getBelongToCategoryID().remove(category.getId()));

                categoryRepository.save(cate.get());
            }
        }
        if (category.getBelongToCategoryID()!= null){
            for (Long idCate : category.getBelongToCategoryID()) {
                Optional<Category> cate=getCategoryById(id);
                cate.ifPresent(value -> value.deleteHasCategoryID(category));
                categoryRepository.save(cate.get());
            }

        }

        /** Need improve after update Product*/




        categoryRepository.delete(category);
    }




    @Override
    public Product addProduct(Long id, Product newProduct) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category category1 = category.get();
            newProduct.setCategory(category1);
            productRepository.save(newProduct);
        }
       return newProduct;
    }




}
