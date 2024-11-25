package com.joao.desafiotecnico.gerenciamentoautomoveis.repository;

import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    boolean existsByVeiculoId(Long veiculoId);
}
