package com.example.springreactiveroutes.service;

import com.example.springreactiveroutes.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class ProductService {
    public Flux<Product> getAll(){
        var p1 = new Product();
        p1.setName("Beer");
        var p2 = new Product();
        p2.setName("Chocolate");

        Flux<Product> products = Flux.fromStream(List.of(p1, p2).stream())
                .delayElements(Duration.ofSeconds(5));

        return products;
    }
}
