package com.joao.desafiotecnico.gerenciamentoautomoveis.service;

import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Opcional;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Veiculo;
import com.joao.desafiotecnico.gerenciamentoautomoveis.repository.OpcionalRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VeiculoService {

    private final OpcionalRepository opcionalRepository;

    public VeiculoService(OpcionalRepository opcionalRepository) {
        this.opcionalRepository = opcionalRepository;
    }

    public Veiculo obterVeiculoPorId(Long veiculoId) {
        return new Veiculo(veiculoId, "Modelo Exemplo", BigDecimal.valueOf(30000));
    }

    public List<Opcional> obterOpcionaisPorIds(List<Long> opcionaisIds) {
        return opcionalRepository.findAllById(opcionaisIds);
    }
}

