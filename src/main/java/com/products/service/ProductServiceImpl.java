package com.products.service;

import com.products.model.Product;
import com.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllTheProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addAndUpdate(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = getProduct(id);
        if (product == null)
            return null;
        productRepository.deleteById(id);
        return product;
    }
}
