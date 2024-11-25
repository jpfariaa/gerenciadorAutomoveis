package com.joao.desafiotecnico.gerenciamentoautomoveis.repository;

import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
