package com.spring.ecommerce.service;


import com.spring.ecommerce.persistence.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Long id);
    public Optional<Product> getProductByName(String name);
    public Product save(Product product);
    public List<Product> saveAll(List<Product> products);
    public Product updateProduct(Long productId,Product product);
    public void deleteProductById(Long id);
}
