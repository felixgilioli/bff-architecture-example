package br.com.felixgilioli.bff.api.doc;

import br.com.felixgilioli.bff.framework.DocumentationData;
import br.com.felixgilioli.bff.model.Pedido;
import br.com.felixgilioli.bff.model.PedidoStatus;

public class PedidoAguardandoDoc implements DocumentationData {

    @Override
    public Object getData() {
        return new Pedido(
                1L,
                "Compra de caneta",
                PedidoStatus.AGUARDANDO_PAGAMENTO
        );
    }
}
