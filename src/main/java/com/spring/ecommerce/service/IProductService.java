package com.spring.ecommerce.service;


import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public List<Product> findAll();
    public Optional<Product> findById(Long id);
    public Optional<Product> findByName(String name);

    public Product save(Product product, Long categoryId);
    public List<Product> saveAll(List<Product> products);
    public Product updateProduct(Long productId,Product product);
    public void deleteProductById(Long id);
    public void updateCategoryOfProduct(Long productId, Long categoryId);

}
