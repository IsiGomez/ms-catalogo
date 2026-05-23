package cl.duoc.catalogo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio de Cátalogo API")
                        .version("1.0.0")
                        .description("Documentación interactiva de los endpoints de catalogo"));
    }

    @Bean
    public GroupedOpenApi categoriesApi() {
        return GroupedOpenApi.builder()
                .group("1. Módulo de Categorías")
                .pathsToMatch("/api/v1/categories/**")
                .build();
    }

    @Bean
    public GroupedOpenApi productsApi(){
        return GroupedOpenApi.builder()
                .group("2. Módulo de Productos")
                .pathsToMatch("/api/v1/products/**")
                .build();
    }

}
