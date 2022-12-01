package com.example.reactiveroutes.config;

import com.example.reactiveroutes.model.Product;
import com.example.reactiveroutes.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> router(ProductService productService){
        return route()
                .GET("/products",
                        request -> ok()
                                .contentType(MediaType.TEXT_EVENT_STREAM) // very important as it is a reactive programming
                                .body(productService.getAll(), Product.class))
                .build();

    }
}
