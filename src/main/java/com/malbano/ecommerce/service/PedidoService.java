package com.malbano.ecommerce.service;

import com.malbano.ecommerce.dto.request.PedidoRequest;
import com.malbano.ecommerce.dto.request.ProdutoRequest;
import com.malbano.ecommerce.exception.NotFoundException;
import com.malbano.ecommerce.mapper.PedidoMapper;
import com.malbano.ecommerce.mapper.ProdutoMapper;
import com.malbano.ecommerce.model.Pedido;
import com.malbano.ecommerce.model.Produto;
import com.malbano.ecommerce.repository.PedidoRepositoy;
import com.malbano.ecommerce.repository.ProdutoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class PedidoService {

    @Autowired
    private PedidoRepositoy repositoy;

    @Transactional
    public void cadastrar(PedidoRequest request) {

        repositoy.salvarPedido(request.getCliente().getId());
    }

    @Transactional
    public void atualizar(Integer id, PedidoRequest request) {

        repositoy.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));

        Pedido pedido = PedidoMapper.INSTANCE.requestToEntity(request);

        repositoy.updatePedidoById(id, pedido.getDataPedido(), pedido.getCliente().getId());
    }

    public Pedido getPedidoById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
    }

    public List<Pedido> getAllPedidos() {
        return repositoy.findAll();
    }
}
