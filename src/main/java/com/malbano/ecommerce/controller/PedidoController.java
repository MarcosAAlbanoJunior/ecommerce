package com.malbano.ecommerce.controller;

import com.malbano.ecommerce.dto.request.PedidoRequest;
import com.malbano.ecommerce.dto.request.ProdutoRequest;
import com.malbano.ecommerce.model.Pedido;
import com.malbano.ecommerce.model.Produto;
import com.malbano.ecommerce.service.PedidoService;
import com.malbano.ecommerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Operation(summary = "Retorna um Pedido com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") Integer id) {
        Pedido pedido = service.getPedidoById(id);
        return ResponseEntity.ok(pedido);
    }

    @Operation(summary = "Retorna todos os pedidos")
    @GetMapping
    public ResponseEntity<List<Pedido>> getPedidos() {
        List<Pedido> pedidos = service.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @Operation(summary = "Cadastra um Pedido")
    @PostMapping
    public ResponseEntity<Void> cadastrarPedido(@RequestBody PedidoRequest request) {
        service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Atualiza um Pedido")
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPedido(@PathVariable Integer id, @RequestBody PedidoRequest request) {
        service.atualizar(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
