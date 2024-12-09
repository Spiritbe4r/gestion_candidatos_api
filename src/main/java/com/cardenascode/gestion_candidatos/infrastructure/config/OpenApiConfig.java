package com.cardenascode.gestion_candidatos.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI humanResourcesOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Human Resources API")
                        .description("API para gestión de Recursos Humanos")
                        .version("1.0"));
    }
}