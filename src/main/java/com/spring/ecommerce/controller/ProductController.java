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

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/getProductByID/{proID}")
    public ResponseEntity<Product> getProductByID(@PathVariable("proID") long proID) {
        Optional<Product> product = productService.getProductById(proID);
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }


    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @PostMapping("/addAllProduct")
    public ResponseEntity<Product> addAllProduct(@RequestBody List<Product> products) {
        List<Product> productList = productService.saveAll(products);
         return new ResponseEntity<>(products.get(0), HttpStatus.OK);
    }


    @PutMapping("/updateProduct/{proID}")
    public ResponseEntity<Product> updateProduct(@PathVariable("proID") long proID, @RequestBody Product product) {
        productService.updateProduct(proID, product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("/deleteProduct/{proID}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("proID") long proID) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
