package br.com.felixgilioli.bff.api.impl;

import br.com.felixgilioli.bff.api.PedidoApi;
import br.com.felixgilioli.bff.model.Pedido;
import br.com.felixgilioli.bff.service.PedidoService;
import br.com.felixgilioli.bff.template.TemplateEngine;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(templateEngine.getTemplate(TEMPLATE_NAME, pedido.get()));
    }

    @Override
    public ResponseEntity<List<Pedido>> getPedidos() {
        List<Pedido> pedidos = pedidoService.findAll();

        if (CollectionUtils.isEmpty(pedidos)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pedidos);
    }
}
