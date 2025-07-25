package com.example.camara_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200") // <-- ¡¡CAMBIA DE "*" A TU ORIGEN ESPECÍFICO!!
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
        // Si tienes otros orígenes en el futuro (ej. un dominio de producción), los añadirías aquí:
        // .allowedOrigins("http://localhost:4200", "https://tudominio.com")
    }
}