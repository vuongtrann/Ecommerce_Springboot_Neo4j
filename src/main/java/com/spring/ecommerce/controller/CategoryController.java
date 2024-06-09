package com.spring.ecommerce.controller;

import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/categories")
    public ResponseEntity<List<Category> > getAllCategorys() {
        List<Category> categoryList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @GetMapping("/category/{categoryID}")
    public ResponseEntity<Category> getCategoryByID(@PathVariable("categoryID") Long categoryID) {
        Optional<Category> category= categoryService.getCategoryById( categoryID);
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }


    @PostMapping("/category/add")
    public ResponseEntity<Category> addCategory( @RequestBody Category category) {
        Category saveCategory = categoryService.save(category);
        return new ResponseEntity<>(saveCategory, HttpStatus.OK);
    }


    @PostMapping("/category/addList")
    public ResponseEntity<List<Category>> addAllCategory(@RequestBody List<Category> category) {
        List<Category> saveCategory = categoryService.saveAll(category);
        return new ResponseEntity<>(saveCategory, HttpStatus.OK);
    }


    @PutMapping ("/category/{categoryId}/update")
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryID") Long categoryID, @RequestBody Category category) {
        Category saveCategory= categoryService.update(categoryID, category);
        return new ResponseEntity<>(saveCategory, HttpStatus.OK);
    }


    @DeleteMapping("/category/{categoryID}/delete")
    public ResponseEntity<Category> deleteCategory(@PathVariable("categoryID") Long categoryID) {
        categoryService.deleteById(categoryID);
        return new ResponseEntity<>(HttpStatus.OK);
    }













}
