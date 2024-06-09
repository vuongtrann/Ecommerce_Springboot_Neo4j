package com.spring.ecommerce.controller;

import com.spring.ecommerce.persistence.dao.ProductRepository;
import com.spring.ecommerce.persistence.model.Product;
import com.spring.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{productID}")
    public ResponseEntity<Product> getProductByID(@PathVariable("productID") long proID) {
        Optional<Product> product = productService.getProductById(proID);
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }


    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @PostMapping("/product/addList")
    public ResponseEntity<?> addAllProduct(@RequestBody List<Product> products) {
        List<Product> productList = productService.saveAll(products);
         return new ResponseEntity<>("Them san pham thanh cong !",HttpStatus.OK);
    }


    @PutMapping("/pruduct/{productID}/update")
    public ResponseEntity<Product> updateProduct(@PathVariable("productID") long proID, @RequestBody Product product) {
        productService.updateProduct(proID, product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("/product/{productID}/delete")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productID") long proID) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
