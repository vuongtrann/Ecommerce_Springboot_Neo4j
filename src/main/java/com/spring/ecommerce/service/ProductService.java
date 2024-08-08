package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.dao.ProductRepository;
import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.empty();
    }



    @Override
    public Product save(Product product, Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
           product.addCategory(category.get());
        }
        return  productRepository.save(product);


    }



    @Override
    public Product updateProduct(Long productId, Product product) {
        Product oldProduct = productRepository.findById(productId).orElseThrow();
        oldProduct.update(product);
        return productRepository.save(oldProduct);
    }



    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);

    }







    @Override
    public List<Product> saveAll(List<Product> products) {
        //return productRepository.saveAll(products);
        return  null;

    }




    @Override
    public void updateCategoryOfProduct(Long productId, Long categoryId) {
        try {
            Product product = productRepository.findById(productId).orElseThrow();
            Category category = categoryRepository.findById(categoryId).orElseThrow();
            product.addCategory(category);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException("Not found");
        }
    }
}
