package com.malbano.ecommerce.controller;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Operation(summary = "Retorna um Cliente com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getByCpf(@PathVariable("id") Long id) {
        Cliente cliente = service.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Retorna todos os clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAlunos() {
        List<Cliente> clientes = service.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Cadastra um Cliente")
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteRequest request) {
        Cliente cliente = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @Operation(summary = "Atualiza um Cliente")
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest request) {
        service.atualizar(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
