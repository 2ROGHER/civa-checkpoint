package com.example.api_gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * This class is used to configure  and create a custom [routes].
 */
@Component
public class RouterConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                // 1. Configure Routes to redirect and relay to [auth-ms]
                .route("auth-route", p -> p
                        .path("/api/v1/auth/**")
                        .filters(f -> f
                                .rewritePath("/api/v1/(?<segment>.*", "${segment}") // Remove the "/api/v1/"
                                .addRequestHeader("Hello", "World!")
                        )
                        .uri("http://localhost:8081") // Redirect to 'http://localhost:8081', auth endpoint.
                )
                //2. Configure the Routes to redirect and relay to [users-ms]
                .route("users-route", p -> p
                        .path("/api/v1/users/**")
                        .filters(f -> f
                                .rewritePath("/api/v1/(?<segment>.*", "${segment}") // Remove the "/api/v1/"
                                .addRequestHeader("Users", "users")
                        )
                        .uri("http://localhost:8082")
                )
                .build();
    }
}
