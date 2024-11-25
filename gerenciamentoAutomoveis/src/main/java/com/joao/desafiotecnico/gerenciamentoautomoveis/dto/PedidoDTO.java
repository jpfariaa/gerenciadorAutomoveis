package com.joao.desafiotecnico.gerenciamentoautomoveis.dto;

import java.util.List;

public class PedidoDTO {

    private Long veiculoId;
    private List<Long> opcionaisIds;

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public List<Long> getOpcionaisIds() {
        return opcionaisIds;
    }

    public void setOpcionaisIds(List<Long> opcionaisIds) {
        this.opcionaisIds = opcionaisIds;
    }
}
