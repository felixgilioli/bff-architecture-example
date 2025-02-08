package br.com.felixgilioli.bff.api.doc;

import br.com.felixgilioli.bff.framework.DocumentationData;
import br.com.felixgilioli.bff.model.Pedido;
import br.com.felixgilioli.bff.model.PedidoStatus;

public class PedidoCanceladoDoc implements DocumentationData {

    @Override
    public Object getData() {
        return new Pedido(
                2L,
                "Compra de caneta",
                PedidoStatus.CANCELADO
        );
    }
}
