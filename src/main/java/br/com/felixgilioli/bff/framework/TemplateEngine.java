package br.com.felixgilioli.bff.framework;

public interface TemplateEngine {

    String getTemplate(String name, Object data);
}
