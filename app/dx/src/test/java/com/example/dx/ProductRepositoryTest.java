package com.example.dx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void testFindByNameContaining() {
        Product product = new Product("Laptop", "LT123", "Powerful laptop", "Dell", "USD", 1200.0, 10);
        repository.save(product);
        List<Product> products = repository.findByNameContaining("Laptop");
        assertThat(products).isNotEmpty();
    }

    
}
