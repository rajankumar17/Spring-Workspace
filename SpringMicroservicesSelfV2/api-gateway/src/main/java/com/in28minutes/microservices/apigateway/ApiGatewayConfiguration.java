package com.in28minutes.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    // Test using url : http://localhost:8765/get
    //http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/2000
    //http://localhost:8765/currency-exchange/from/USD/to/INR
    //http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/2000
    //Note: for route to function , we need to comment the properties related to eureka i.e #spring.cloud.gateway.discovery.locator.enabled=true
    //#spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get").filters(f -> f.addRequestHeader("MyHeader", "MyURI").addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80")).route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
                .route(p -> p.path("/currency-conversion-service/**").uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion-service")).build();
    }

}