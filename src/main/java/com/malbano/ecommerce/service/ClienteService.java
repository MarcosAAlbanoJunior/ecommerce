package com.malbano.ecommerce.service;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import com.malbano.ecommerce.exception.NotFoundException;
import com.malbano.ecommerce.mapper.ClienteMapper;
import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.repository.ClienteRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoy repositoy;

    @Transactional
    public Cliente cadastrar(ClienteRequest request) {

        return  repositoy.saveAndFlush(ClienteMapper.INSTANCE.requestToEntity(request));
    }

    @Transactional
    public void atualizar(Long id, ClienteRequest request) {

        repositoy.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        Cliente cliente = ClienteMapper.INSTANCE.requestToEntity(request);

        repositoy.updateClienteById(id, cliente.getNome(), cliente.getEmail());
    }

    public Cliente getClienteById(Long id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    public List<Cliente> getAllClientes() {
        return repositoy.findAll();
    }
}
