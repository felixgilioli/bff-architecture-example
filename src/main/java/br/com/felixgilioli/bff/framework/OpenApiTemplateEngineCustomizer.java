package br.com.felixgilioli.bff.framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

@Component
public class OpenApiTemplateEngineCustomizer implements OperationCustomizer {

    private final TemplateEngine templateEngine;

    public OpenApiTemplateEngineCustomizer(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        ApiResponse apiResponse = operation.getResponses().get("200");
        Documentation documentation = handlerMethod.getMethodAnnotation(Documentation.class);

        if (apiResponse == null || documentation == null) {
            return operation;
        }

        try {
            var documentationData = documentation.data().getDeclaredConstructor().newInstance();

            var jsonString = templateEngine.getTemplate(documentation.template(), documentationData.getData());

            apiResponse.content(new Content().addMediaType("application/json", new MediaType()
                    .addExamples(
                            "Exemplo de resposta",
                            new Example().value(toJson(jsonString))
                    )));

        } catch (Exception e) {
            return operation;
        }

        return operation;
    }

    public Object toJson(String jsonString) {
        try {
            return new ObjectMapper().readTree(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
