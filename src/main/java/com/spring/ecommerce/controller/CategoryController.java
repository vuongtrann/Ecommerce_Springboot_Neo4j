package com.spring.ecommerce.controller;

import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;
import com.spring.ecommerce.service.CategoryService;
import com.spring.ecommerce.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**Get all category*/
    @GetMapping("")
    public RestResponse getAllCategorys() {
        List<Category> categoryList = categoryService.findAll();
        return RestResponse.builder(categoryList).message("Success").build();
    }

    /** Get category by ID*/
    @GetMapping("/{categoryID}")
    public RestResponse getCategoryByID(@PathVariable("categoryID") Long categoryID) {
        Optional<Category> category= categoryService.findById( categoryID);
        return RestResponse.builder(category.get()).message("Success").build();
    }


    /** Add category*/
    @PostMapping("/add")
    public RestResponse addCategory( @RequestBody Category category) {
        Category saveCategory = categoryService.save(category);
        return RestResponse.builder(saveCategory).message("Success").build();
    }


    /** Add list category */
    @PostMapping("/addList")
    public RestResponse addAllCategory(@RequestBody List<Category> category) {
        List<Category> saveCategory = categoryService.saveAll(category);
        return RestResponse.builder(saveCategory).message("Success").build();
    }


    /** Update category*/
    @PutMapping ("/{categoryID}/update")
    public RestResponse updateCategory(@PathVariable("categoryID") Long categoryID, @RequestBody Category category) {
        Category saveCategory= categoryService.update(categoryID, category);
        return RestResponse.builder(saveCategory).message("Success").build();
    }



    /**Delete category*/
    @DeleteMapping("/{categoryID}/delete")
    public RestResponse deleteCategory(@PathVariable("categoryID") Long categoryID) {
        categoryService.deleteById(categoryID);
        return RestResponse.builder(categoryID).message("Success").build();
    }





    /** Add category with other category */
    @PostMapping("/{categoryID}/add")
    public RestResponse addCategory( @RequestBody Category category, @PathVariable("categoryID") Long categoryID) {
        Category saveCategory = categoryService.saveWithOthersCate( category, categoryID);
        return RestResponse.builder(saveCategory).message("Success").build();
    }



}
