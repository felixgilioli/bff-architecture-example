package br.com.felixgilioli.bff.api;

import br.com.felixgilioli.bff.api.doc.PedidoDoc;
import br.com.felixgilioli.bff.framework.Documentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/screen/pedido")
public interface PedidoApi {

    String TEMPLATE_NAME = "pedido";

    @GetMapping("/{pedidoId}")
    @Documentation(template = TEMPLATE_NAME, data = PedidoDoc.class)
    ResponseEntity<Object> getPedidoScreen(@PathVariable Long pedidoId);
}
