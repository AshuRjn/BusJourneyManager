package com.mapping.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    //use this uri for swagger
   // http://localhost:9999/swagger-ui/swagger-ui/index.html#

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Bus Reservation") // Defines the group name for the Swagger UI
                .pathsToMatch("/api/**") // Specifies the paths to include in the documentation
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bus Reservation System API")  // Custom title for your API documentation
                        .description("API documentation for the bus reservation system")  // Description of your API
                        .version("1.0.0"));  // Version of your API
    }
}
