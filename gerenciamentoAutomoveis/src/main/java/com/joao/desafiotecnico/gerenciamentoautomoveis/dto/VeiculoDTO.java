package com.joao.desafiotecnico.gerenciamentoautomoveis.dto;

import java.math.BigDecimal;

public class VeiculoDTO {

    private Long id;
    private String modelo;
    private BigDecimal precoBase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }
}
