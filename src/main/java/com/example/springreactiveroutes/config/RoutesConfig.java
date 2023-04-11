package com.example.springreactiveroutes.config;

import com.example.springreactiveroutes.handler.ProductHandler;
import com.example.springreactiveroutes.model.Product;
import com.example.springreactiveroutes.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfig {
//    private final ProductService productService;
//
//    public RoutesConfig(ProductService productService) {
//        this.productService = productService;
//    }  // this is no need, it is using in ProductHandler

    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler handler){
        //ProductHandler is component
        //ProductHandler is autowired when ProductHandler has @Component and it using in @Bean method.
        return route().GET("/products", handler::getAll).build(); //handler::getAll() is method reference way written pattern

    }
}
