package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Override
    public List<Product> findBy() {
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
    public Product update(int productId, Product product) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
