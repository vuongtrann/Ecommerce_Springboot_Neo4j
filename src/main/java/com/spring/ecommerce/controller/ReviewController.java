package com.spring.ecommerce.controller;

import com.spring.ecommerce.persistence.model.Evalues;
import com.spring.ecommerce.persistence.model.Product;
import com.spring.ecommerce.service.EvaluesService;
import com.spring.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private EvaluesService reviewService;

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public Evalues getReview(@PathVariable Long id) {
        return reviewService.getReview(id).get();
    }

    @PostMapping("/add/{idProduct}")
    public Evalues addReview(@RequestBody Evalues evalues, @PathVariable Long idProduct) {
        Optional<Product> product = productService.findById(idProduct);
        if (product.isPresent()) {

        }
        return reviewService.addReview(evalues);
    }


    @DeleteMapping("delete/{id}")
    public void deleteReview(@PathVariable Long id) {
         reviewService.delete(id);
    }



}
