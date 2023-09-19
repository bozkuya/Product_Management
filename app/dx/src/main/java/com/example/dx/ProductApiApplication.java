package com.example.dx;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// Main class for the Spring Boot application
@SpringBootApplication
public class ProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }
    // Bean definition to run code on application startup
    @Bean
    public CommandLineRunner initDatabase(ProductService service) {
        return args -> {
            service.createProduct(new Product("Laptop", "LT123", "Powerful laptop", "Dell", "USD", 1200.0, 10));
            service.createProduct(new Product("Phone", "PH456", "Latest mobile phone", "Apple", "USD", 999.0, 15));
            service.createProduct(new Product("Smartwatch", "SW789", "Fitness tracker", "Fitbit", "USD", 199.0, 20));
            service.createProduct(new Product("Headphones", "HP012", "Wireless noise-canceling headphones", "Sony", "USD", 349.0, 5));
            service.createProduct(new Product("Camera", "CM345", "Mirrorless camera with 4K video recording", "Canon", "USD", 1299.0, 8));
            service.createProduct(new Product("Smart TV", "TV678", "4K Ultra HD Smart LED TV", "Samsung", "USD", 899.0, 12));
            service.createProduct(new Product("Gaming Console", "GC901", "Next-gen gaming console with ray tracing support", "Microsoft", "USD", 499.0, 7));
            service.createProduct(new Product("Wireless Router", "WR234", "High-speed Wi-Fi router with MU-MIMO technology", "Netgear", "USD", 149.0, 15));
            service.createProduct(new Product("External Hard Drive", "HD567", "Portable USB 3.0 hard drive with 2TB storage capacity", "Seagate", "USD", 79.0, 18));
            service.createProduct(new Product("Wireless Earbuds", "WE890", "True wireless earbuds with active noise cancellation", "Jabra", "USD", 199.0, 10));
            service.createProduct(new Product("Tablet", "TB0123", "10-inch Android tablet with quad-core processor and Full HD display", "Lenovo", "USD", 299.0, 6));
            service.createProduct(new Product("Bluetooth Speaker", "BS4567", "Waterproof portable speaker with built-in microphone and long battery life","JBL","USD" ,99.0 ,25));

        };
    }
}
