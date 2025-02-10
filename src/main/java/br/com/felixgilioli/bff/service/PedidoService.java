package br.com.felixgilioli.bff.service;

import br.com.felixgilioli.bff.model.Pedido;
import br.com.felixgilioli.bff.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
