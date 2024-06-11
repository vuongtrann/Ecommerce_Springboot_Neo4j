package com.spring.ecommerce.controller;

import com.spring.ecommerce.persistence.dao.ProductRepository;
import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;
import com.spring.ecommerce.service.ProductService;
import com.spring.ecommerce.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /** Get all product*/
    @GetMapping("")
    public RestResponse getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return RestResponse.builder(products).message("Success").build();
    }
    /** Get product by ID*/
    @GetMapping("/{productID}")
    public RestResponse getProductByID(@PathVariable("productID") long proID) {
        Optional<Product> product = productService.getProductById(proID);
        return RestResponse.builder(product).message("Success").build();
    }

    /**Add product*/
    @PostMapping("/add")
    public RestResponse addProduct(@RequestBody Product product) {
        productService.save(product);
        return RestResponse.builder(product).message("Success").build();
    }
    
    /** Add list product*/
    @PostMapping("/addList")
    public RestResponse addAllProduct(@RequestBody List<Product> products) {
        List<Product> productList = productService.saveAll(products);
         return RestResponse.builder(productList).message("Success").build();
    }

    /**Update product by ID*/
    @PutMapping("/{productID}/update")
    public RestResponse updateProduct(@PathVariable("productID") long proID, @RequestBody Product product) {
        productService.updateProduct(proID, product);
        return RestResponse.builder(product).message("Success").build();
    }

    /**Delete product*/
    @DeleteMapping("/{productID}/delete")
    public RestResponse deleteProduct(@PathVariable("productID") long proID) {
        productService.deleteProductById(proID);
        return RestResponse.builder(HttpStatus.OK).message("Success").build();
    }

    /** Add category by product ID*/
    @PostMapping("{productId}/category")
    public ResponseEntity<Category> addCategory(@PathVariable("productId") long proID, @RequestBody Category category) {
        productService.addCategory(proID, category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /** Update category by product ID*/
    @PutMapping("{productId}/category/{categoryId}")
    public RestResponse updateCategory(@PathVariable("productId") long proID, @PathVariable Long categoryId) {
        productService.updateCategoryOfProduct(proID, categoryId);
        Optional<Product> result = productService.getProductById(proID);
        return RestResponse.builder(result).message("Success").build();
    }
}
