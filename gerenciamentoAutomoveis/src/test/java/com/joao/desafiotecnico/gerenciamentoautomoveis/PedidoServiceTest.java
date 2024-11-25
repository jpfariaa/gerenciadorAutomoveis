package com.joao.desafiotecnico.gerenciamentoautomoveis;

import com.joao.desafiotecnico.gerenciamentoautomoveis.dto.PedidoDTO;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Opcional;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Pedido;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Veiculo;
import com.joao.desafiotecnico.gerenciamentoautomoveis.repository.OpcionalRepository;
import com.joao.desafiotecnico.gerenciamentoautomoveis.repository.VeiculoRepository;
import com.joao.desafiotecnico.gerenciamentoautomoveis.service.PedidoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PedidoServiceTest {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private OpcionalRepository opcionalRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Test
    public void criarPedido_DeveCalcularPrecoTotal() {

        Opcional opcional1 = new Opcional("Ar-condicionado", BigDecimal.valueOf(3000));
        Opcional opcional2 = new Opcional("Teto solar", BigDecimal.valueOf(4500));

        opcionalRepository.save(opcional1);
        opcionalRepository.save(opcional2);

        Veiculo veiculo = new Veiculo("Carro X", BigDecimal.valueOf(50000));
        veiculoRepository.save(veiculo);

        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setVeiculoId(veiculo.getId());
        pedidoDTO.setOpcionaisIds(Arrays.asList(opcional1.getId(), opcional2.getId()));

        Pedido pedidoCriado = pedidoService.criarPedido(pedidoDTO);

        BigDecimal precoEsperado = veiculo.getPrecoBase()
                .add(opcional1.getPreco())
                .add(opcional2.getPreco());

        assertEquals(precoEsperado, pedidoCriado.getPrecoTotal());
    }
}

