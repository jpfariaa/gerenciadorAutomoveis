package com.joao.desafiotecnico.gerenciamentoautomoveis.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veiculo veiculo;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Opcional> opcionais;

    private BigDecimal precoTotal;

    public Pedido(Veiculo veiculo, List<Opcional> opcionais) {
        this.veiculo = veiculo;
        this.opcionais = opcionais;
    }

    public Pedido() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Opcional> getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(List<Opcional> opcionais) {
        if (this.opcionais != null) {
            this.opcionais.forEach(o -> o.setPedido(null));
        }
        if (opcionais != null) {
            this.opcionais = opcionais;
            this.opcionais.forEach(o -> o.setPedido(this));
        }
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }
}

