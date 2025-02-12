package br.com.felixgilioli.bff.api;

import br.com.felixgilioli.bff.api.doc.PedidoAguardandoDoc;
import br.com.felixgilioli.bff.api.doc.PedidoCanceladoDoc;
import br.com.felixgilioli.bff.doc.ResponseExample;
import br.com.felixgilioli.bff.doc.Responses;
import br.com.felixgilioli.bff.model.Pedido;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/screen/pedido")
@Tag(name = "API da tela de pedidos", description = "Operações referentes a montagem da tela de pedido.")
public interface PedidoApi {

    String TEMPLATE_NAME = "pedido";

    @GetMapping("/{pedidoId}")
    @Responses({
            @ResponseExample(status = 200, template = TEMPLATE_NAME, data = PedidoAguardandoDoc.class, description = "Pedido Aguardando"),
            @ResponseExample(status = 200, template = TEMPLATE_NAME, data = PedidoCanceladoDoc.class)
    })
    ResponseEntity<Object> getPedidoScreen(@PathVariable Long pedidoId);

    @GetMapping
    ResponseEntity<List<Pedido>> getPedidos();

}
