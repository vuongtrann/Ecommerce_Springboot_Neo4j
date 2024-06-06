package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> findAll();
    public Optional<Product> findById(Long id);
    public Optional<Product> findByName(String name);
    public Product save(Product product);
    public Product update(Product product);
    public void deleteById(int id);
}