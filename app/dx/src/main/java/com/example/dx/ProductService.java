package com.example.dx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
// Service class for Product-related business logic
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> searchProducts(String name, String code, String brand, Double minPrice, Double maxPrice) {
    // Take all products
    List<Product> allProducts = repository.findAll();

    // Filtering
    if (name != null) {
        allProducts = allProducts.stream().filter(product -> product.getName().contains(name)).collect(Collectors.toList());
    }
    if (code != null) {
        allProducts = allProducts.stream().filter(product -> product.getCode().contains(code)).collect(Collectors.toList());
    }
    if (brand != null) {
        allProducts = allProducts.stream().filter(product -> product.getBrand().contains(brand)).collect(Collectors.toList());
    }
    if (minPrice != null && maxPrice != null) {
        allProducts = allProducts.stream().filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    return allProducts;
}


    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProduct = getProductById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setCode(product.getCode());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setBrand(product.getBrand());
            updatedProduct.setCurrency(product.getCurrency());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setStock(product.getStock());
            return repository.save(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
