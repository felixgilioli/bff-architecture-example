package br.com.felixgilioli.bff.model;

public record Pedido(
        Long id,
        String titulo,
        PedidoStatus status
) {
}
