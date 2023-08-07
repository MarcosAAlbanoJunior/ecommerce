package com.malbano.ecommerce.controller;

import com.malbano.ecommerce.dto.request.ItensPedidoRequest;
import com.malbano.ecommerce.dto.request.PedidoRequest;
import com.malbano.ecommerce.dto.response.ItensPedidoResponse;
import com.malbano.ecommerce.model.ItensPedido;
import com.malbano.ecommerce.model.Pedido;
import com.malbano.ecommerce.service.ItensPedidoService;
import com.malbano.ecommerce.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/pedidos/itens")
public class ItensPedidoController {

    @Autowired
    private ItensPedidoService service;

    @Operation(summary = "Retorna uma Lista de Itens em um Pedido")
    @GetMapping("/{id}")
    public ResponseEntity<ItensPedidoResponse> getPedidoById(@PathVariable("id") Integer id) {
        ItensPedidoResponse itensPedido = service.getPedidoById(id);
        return ResponseEntity.ok(itensPedido);
    }

    @Operation(summary = "Retorna todos os itens associados a um pedido")
    @GetMapping
    public ResponseEntity<List<ItensPedido>> getItensPedidos() {
        List<ItensPedido> itensPedido = service.getAllPedidos();
        return ResponseEntity.ok(itensPedido);
    }

    @Operation(summary = "Cadastra um Item em um Pedido")
    @PostMapping
    public ResponseEntity<ItensPedido> cadastrarItemPedido(@RequestBody ItensPedidoRequest request) {
        service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Atualiza um Item em um Pedido")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarPedido(@PathVariable("id") Integer id, @RequestBody ItensPedidoRequest request) {
        service.atualizarQuantidade(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
