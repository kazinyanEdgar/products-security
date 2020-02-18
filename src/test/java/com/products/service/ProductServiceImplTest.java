package com.products.service;

import com.products.model.Product;
import com.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void getAllTheProducts() {
        List<Product> products = Arrays.asList(
                new Product("Смартфон", 4500),
                new Product("Планшет", 2500));
        when(productRepository.findAll()).thenReturn(products);
        assertEquals(2, productService.getAllTheProducts().size());
    }

    @Test
    void addAndUpdate() {
        Product product = new Product("Смартфон", 4500);
        productService.addAndUpdate(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void getProduct() {
        long id = 1;
        Product product = new Product("Смартфон", 4500);
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        assertEquals(product, productService.getProduct(id));
    }

    @Test
    void deleteProductThatExists() {
        long id = 1;
        Product product = new Product("Смартфон", 4500);
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        productService.deleteProduct(id);
        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteProductThatDoesntExist() {
        long id = 1;
        when(productRepository.findById(id)).thenReturn(Optional.empty());
        Product product = productService.deleteProduct(id);
        assertNull(product);
        verify(productRepository, never()).deleteById(id);
    }
}