package com.gourmet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(loadResource());
            return resources;
        };
    }

    private SwaggerResource loadResource() {
        SwaggerResource wsResource = new SwaggerResource();
        wsResource.setSwaggerVersion("2.0");
        wsResource.setLocation("/swagger-apis/swagger.yaml");
        return wsResource;
    }
}
