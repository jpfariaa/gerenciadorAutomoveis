package com.joao.desafiotecnico.gerenciamentoautomoveis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private BigDecimal precoBase;

    public Veiculo(Long id, String modeloExemplo, BigDecimal preco) {
        this.id = id;
        this.modelo = modeloExemplo;
        this.precoBase = preco;
    }

    public Veiculo() {

    }

    public Veiculo(String modelo, BigDecimal preco) {
        this.modelo = modelo;
        this.precoBase = preco;
    }

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
