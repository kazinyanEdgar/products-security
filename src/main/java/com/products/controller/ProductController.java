package com.products.controller;

import com.products.model.Product;
import com.products.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/")
    public String mainRedirect() {
        return "redirect:/main";
    }

    @GetMapping("/products")
    public String getAllTheProducts(Model model) {
        List<Product> productList = productService.getAllTheProducts();
        if (productList.size() == 0)
            LOGGER.warn("Database is empty");
        model.addAttribute("products", productList);
        return "products";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute @Valid Product product) {
        productService.addAndUpdate(product);
        LOGGER.debug("Added product: {}", product);
        return "redirect:/products";
    }

    @GetMapping("/products/update")
    public String updateProduct() {
        return "updateProduct";
    }

    @PostMapping("/products/update")
    public String updateProduct(@RequestParam("id") Long id, Model model) {
        Product product = productService.getProduct(id);
        if (product == null) {
            LOGGER.info("Missing product to update with id = {}", id);
            return "errorUpdateOrDelete";
        }
        model.addAttribute("product", product);
        return "updateProductResult";
    }

    @PostMapping("/products/updateProduct")
    public String updateProduct(@ModelAttribute Product product) {
        productService.addAndUpdate(product);
        LOGGER.debug("Updated product: {}", product);
        return "redirect:/products";

    }

    @GetMapping("products/delete")
    public String deleteProduct() {
        return "deleteProduct";
    }

    @PostMapping("products/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        Product product = productService.deleteProduct(id);
        if (product == null) {
            LOGGER.info("Missing product to delete with id = {} ", id);
            return "errorUpdateOrDelete";
        }
        LOGGER.debug("Removed product: {}", product);
        return "redirect:/products";

    }

    @GetMapping("/403")
    public String accessDenied(Principal user) {
        if (user == null)
            return "redirect:/products";
        return "403";
    }
}
