package com.example.camara_backend.config; // <<-- ¡ASEGÚRATE DE QUE ESTE PAQUETE SEA EXACTO!

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.RequestMethod; // <-- Asegúrate de importar RequestMethod

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // <--- ¡MUY IMPORTANTE! Esta ruta debe coincidir con la base de tus controladores.
                // Si tus endpoints son como /camaras o /clientes, cámbialo a "/**"
                .allowedOrigins("http://localhost:4200") // <--- ¡Este es tu frontend Angular!
                .allowedMethods(
                        String.valueOf(RequestMethod.GET),     // Para cargar datos
                        String.valueOf(RequestMethod.POST),    // Para crear nuevos registros
                        String.valueOf(RequestMethod.PUT),     // Para actualizar
                        String.valueOf(RequestMethod.DELETE),  // Para borrar
                        String.valueOf(RequestMethod.OPTIONS)  // Necesario para CORS pre-flight requests
                )
                .allowedHeaders("*")
                .allowCredentials(true);
        // La sección de comentarios debajo es solo un ejemplo, no la necesitas en tu código final.
    }
}