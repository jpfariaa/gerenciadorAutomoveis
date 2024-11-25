package com.joao.desafiotecnico.gerenciamentoautomoveis.service;

import com.joao.desafiotecnico.gerenciamentoautomoveis.dto.PedidoDTO;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Opcional;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Pedido;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Veiculo;
import com.joao.desafiotecnico.gerenciamentoautomoveis.repository.OpcionalRepository;
import com.joao.desafiotecnico.gerenciamentoautomoveis.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private VeiculoService veiculoService;

    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Veiculo veiculo = veiculoService.obterVeiculoPorId(pedidoDTO.getVeiculoId());
        List<Opcional> opcionais = veiculoService.obterOpcionaisPorIds(pedidoDTO.getOpcionaisIds());

        if (pedidoRepository.existsByVeiculoId(veiculo.getId())) {
            throw new IllegalArgumentException("Pedido duplicado");
        }

        BigDecimal precoTotal = veiculo.getPrecoBase();
        for (Opcional opcional : opcionais) {
            precoTotal = precoTotal.add(opcional.getPreco());
        }

        Pedido pedido = new Pedido();
        pedido.setVeiculo(veiculo);
        pedido.setOpcionais(opcionais);
        pedido.setPrecoTotal(precoTotal);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}

