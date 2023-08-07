package com.malbano.ecommerce.controller;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import com.malbano.ecommerce.dto.request.ProdutoRequest;
import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.model.Produto;
import com.malbano.ecommerce.service.ClienteService;
import com.malbano.ecommerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Operation(summary = "Retorna um Produto com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Integer id) {
        Produto produto = service.getProdutoById(id);
        return ResponseEntity.ok(produto);
    }

    @Operation(summary = "Retorna todos os produtos")
    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = service.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "Cadastra um Produto")
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody ProdutoRequest request) {
        Produto produto = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @Operation(summary = "Atualiza um Produto")
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoRequest request) {
        service.atualizar(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Atualiza o preço de um Produto")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarPrecoProduto(@PathVariable Integer id, @RequestBody ProdutoRequest request) {
        service.atualizarPreco(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
