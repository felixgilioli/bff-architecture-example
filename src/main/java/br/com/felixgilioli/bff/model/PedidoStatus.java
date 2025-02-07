package br.com.felixgilioli.bff.model;

public enum PedidoStatus {
    AGUARDANDO_PAGAMENTO("Aguardando pagamento"),
    CANCELADO("Cancelado"),
    CONCLUIDO("Concluido");

    private final String label;

    PedidoStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
