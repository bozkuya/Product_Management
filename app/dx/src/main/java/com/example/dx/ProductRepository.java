package com.example.dx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
// JPA Repository for Product entities
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Query to find products by part of their name
    List<Product> findByNameContaining(String name);
    // Query to find products by part of their code
    List<Product> findByCodeContaining(String code);
    // Query to find products by part of their brand
    List<Product> findByBrandContaining(String brand);
    // Query to find products within a price range
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
