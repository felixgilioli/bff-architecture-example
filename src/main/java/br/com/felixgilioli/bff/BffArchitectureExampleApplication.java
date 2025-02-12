package br.com.felixgilioli.bff;

import br.com.felixgilioli.bff.config.EnableTemplateEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableTemplateEngine
@SpringBootApplication
public class BffArchitectureExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffArchitectureExampleApplication.class, args);
    }

}
