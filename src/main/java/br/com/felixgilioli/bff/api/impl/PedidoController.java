package br.com.felixgilioli.bff.api.impl;

import br.com.felixgilioli.bff.api.PedidoApi;
import br.com.felixgilioli.bff.framework.TemplateEngine;
import br.com.felixgilioli.bff.model.Pedido;
import br.com.felixgilioli.bff.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PedidoController implements PedidoApi {

    private final PedidoService pedidoService;
    private final TemplateEngine templateEngine;

    public PedidoController(PedidoService pedidoService, TemplateEngine templateEngine) {
        this.pedidoService = pedidoService;
        this.templateEngine = templateEngine;
    }

    @Override
    public ResponseEntity<Object> getPedidoScreen(Long pedidoId) {
        Optional<Pedido> pedido = pedidoService.findById(pedidoId);

        if (pedido.isEmpty()) {
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(templateEngine.getTemplate(TEMPLATE_NAME, pedido.get()));
    }
}
