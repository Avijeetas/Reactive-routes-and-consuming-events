package com.example.reactiveroutes.service;

import com.example.reactiveroutes.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class ProductService {
    public Flux<Product> getAll(){
        var p1 = new Product("Milk");
        var p2 = new Product("Mango");
        var p3 = new Product("Juice");
        Flux<Product> products =
                        Flux.fromStream(List.of(p1, p2, p3 ).stream())
                        .delayElements(Duration.ofSeconds(5)).log();

        return products;
    }
}
