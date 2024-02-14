package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración para Swagger.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Bean para proporcionar una configuración personalizada de OpenAPI.
     *
     * @return OpenAPI: La configuración personalizada de OpenAPI.
     */
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("Despliegue a aws")
                        .description("Api para estudiar y probar docker, aws y kubernetes")
                        .version("v0.0.1")
                        .termsOfService("")
                );
    }

}
