package br.com.felixgilioli.bff.framework;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OpenApiProperties.class)
public class OpenApiConfig {

    private final OpenApiProperties properties;

    public OpenApiConfig(OpenApiProperties properties) {
        this.properties = properties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(properties.title())
                        .description(properties.description())
                        .version(properties.version()));
    }
}
