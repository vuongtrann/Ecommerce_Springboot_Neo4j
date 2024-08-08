package com.spring.ecommerce.controller;

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
        List<Product> products = productService.findAll();
        return RestResponse.builder(products).message("Success").build();
    }
    /** Get product by ID*/
    @GetMapping("/{productID}")
    public RestResponse getProductByID(@PathVariable("productID") Long proID) {
        Optional<Product> product = productService.findById(proID);
        return RestResponse.builder(product).message("Success").build();
    }

    /**Add product*/
    @PostMapping("/add")
    public RestResponse add(
            @RequestBody Product product,
            @RequestParam(value = "categoryId" , required = false) Long categoryId
           ) {
        productService.save(product, categoryId);
        return RestResponse.builder(product).message("Success").build();
    }


    
    /** Add list product*/
    @PostMapping("/addList")
    public RestResponse addAll(@RequestBody List<Product> products) {
//        List<Product> productList = productService.saveAll(products);
//         return RestResponse.builder(productList).message("Success").build();
        return null;
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


    /** Update category by product ID*/
    @PutMapping("{productId}/category/{categoryId}")
    public RestResponse updateCategoryOfProduct(@PathVariable("productId") long proID, @PathVariable Long categoryId) {
        productService.updateCategoryOfProduct(proID, categoryId);
        Optional<Product> result = productService.findById(proID);
        return RestResponse.builder(result).message("Success").build();
    }
}
