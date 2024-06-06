package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
