package com.products.service;

import com.products.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllTheProducts();

    void addAndUpdate(Product product);

    Product getProduct(Long id);

    Product deleteProduct(Long id);
}
