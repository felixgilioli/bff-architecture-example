package br.com.felixgilioli.bff.framework;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "documentation.info")
public record OpenApiProperties(
        String title,
        String description,
        String version
) {
}
