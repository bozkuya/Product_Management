package com.example.dx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
// Rest Controller for handling product-related HTTP requests
@RestController
@RequestMapping("/api/products")
public class ProductController {
    // Auto-inject the ProductService
    @Autowired
    private ProductService service;
    // Get all products or filter by name, code, brand, and price
    @GetMapping
    public List<Product> getAllProducts(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String code,
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice
    ) {
        if (name != null || code != null || brand != null || (minPrice != null && maxPrice != null)) {
            return service.searchProducts(name, code, brand, minPrice, maxPrice);
        }
        return service.getProducts();
    }
    // Get a product by its ID
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return service.getProductById(id);
    }
    // Create a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }
    // Update a product by its ID
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }
    // Delete a product by its ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }
    
}
