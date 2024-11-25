package com.joao.desafiotecnico.gerenciamentoautomoveis.controller;

import com.joao.desafiotecnico.gerenciamentoautomoveis.dto.PedidoDTO;
import com.joao.desafiotecnico.gerenciamentoautomoveis.entity.Pedido;
import com.joao.desafiotecnico.gerenciamentoautomoveis.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Car Management", description = "API para gerenciar carros")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Operation(summary = "Realiza a criação dos pedidos.")
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.criarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping
    @Operation(summary = "Lista todos os pedidos", description = "Retorna todos os pedidos cadastrados no sistema.")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
}

