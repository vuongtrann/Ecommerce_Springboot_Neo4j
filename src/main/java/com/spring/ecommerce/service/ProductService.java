package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.ProductRepository;
import com.spring.ecommerce.persistence.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(int productId, Product product) {
        Product updatedProduct = productRepository.findById(productId).orElseThrow();
        updatedProduct.setName(product.getName());
        updatedProduct.setImageURL(product.getImageURL());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setRatting(product.getRatting());
        updatedProduct.setEvaluatting(product.getEvaluatting());
        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);

    }
}
