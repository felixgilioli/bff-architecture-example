package br.com.felixgilioli.bff.repository;

import br.com.felixgilioli.bff.model.Pedido;
import br.com.felixgilioli.bff.model.PedidoStatus;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class PedidoRepository {

    private static final Map<Long, Pedido> PEDIDOS_MOCK = Map.of(
            1L, new Pedido(
                    1L,
                    "Compra de caneta",
                    PedidoStatus.AGUARDANDO_PAGAMENTO
            ),
            2L, new Pedido(
                    2L,
                    "Compra de camiseta",
                    PedidoStatus.CONCLUIDO
            ),
            3L, new Pedido(
                    3L,
                    "Compra de notebook",
                    PedidoStatus.CANCELADO
            )
    );

    public Optional<Pedido> findById(Long id) {
        return Optional.ofNullable(PEDIDOS_MOCK.get(id));
    }
}
