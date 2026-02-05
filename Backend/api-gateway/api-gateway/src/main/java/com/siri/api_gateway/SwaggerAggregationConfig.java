//package com.siri.api_gateway;
//
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springdoc.core.properties.SwaggerUiConfigParameters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.netflix.discovery.converters.Auto;
//
//import jakarta.annotation.PostConstruct;
//
//
//@Configuration
//public class SwaggerAggregationConfig {
//	@Bean
//    public ApplicationListener<ApplicationReadyEvent> readyListener(
//            ReactiveDiscoveryClient discoveryClient,
//            SwaggerUiConfigParameters swaggerUiConfigParameters) {
//
//		return event -> {
//
//            var services = discoveryClient.getServices()
//                    .collectList()
//                    .block(); // ⭐ BLOCK — wait for discovery
//
//            if (services != null) {
//
//                services.forEach(service -> {
//
//                    String url = "/" + service.toLowerCase()+"/v3/api-docs";
//
//                    swaggerUiConfigParameters.addUrl(url);
////                    swaggerUiConfigParameters.addGroup(service);
//
//                    System.out.println(service + " Swagger added for: " + url);
//                });
//            }
//        };
//    } 
//
//}
