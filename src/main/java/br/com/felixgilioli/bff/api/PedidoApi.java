package br.com.felixgilioli.bff.api;

import br.com.felixgilioli.bff.api.doc.PedidoCanceladoDoc;
import br.com.felixgilioli.bff.api.doc.PedidoDoc;
import br.com.felixgilioli.bff.framework.ResponseExample;
import br.com.felixgilioli.bff.framework.Responses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/screen/pedido")
public interface PedidoApi {

    String TEMPLATE_NAME = "pedido";

    @GetMapping("/{pedidoId}")
    @Responses({
            @ResponseExample(status = 202, template = TEMPLATE_NAME, data = PedidoDoc.class, description = "das"),
            @ResponseExample(status = 202, template = TEMPLATE_NAME, data = PedidoCanceladoDoc.class),
            @ResponseExample(status = 200, template = TEMPLATE_NAME, data = PedidoCanceladoDoc.class),
            @ResponseExample(status = 200, template = TEMPLATE_NAME, data = PedidoCanceladoDoc.class),
            @ResponseExample(status = 200, template = TEMPLATE_NAME, data = PedidoCanceladoDoc.class, description = "aaa")
    })
    ResponseEntity<Object> getPedidoScreen(@PathVariable Long pedidoId);

}
