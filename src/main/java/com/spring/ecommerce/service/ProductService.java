package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.CategoryRepository;
import com.spring.ecommerce.persistence.dao.ProductRepository;
import com.spring.ecommerce.persistence.model.Category;
import com.spring.ecommerce.persistence.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return Optional.empty();
    }
    @Override
    public Product add(Product newProduct) {
        Optional<Category> oCategory = categoryRepository.findById(newProduct.getCategory().getId());
        if(oCategory.isPresent()){
            Category category = oCategory.get();
            newProduct.setCategory(category);
        }

        return  productRepository.save(newProduct);
    }
    @Override
    public Product save(Product product) {
        return  productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
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
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);

    }
    @Override
    public Category addCategory(Long productId, Category newCategory) {
//        Optional<Product> optionalProduct = productRepository.findById(productId);
//        if(optionalProduct.isPresent()){
//            Product product = optionalProduct.get();
//            newCategory.setProduct(product);
//            categoryRepository.save(newCategory);
//        }
        return newCategory;
    }

    @Override
    public void updateCategoryOfProduct(Long productId, Long categoryId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        if (optionalProduct.isPresent() && optionalCategory.isPresent()) {
            Product product = optionalProduct.get();
            Category category = optionalCategory.get();

            product.setCategory(category);
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product or Category not found");
        }
    }
}
