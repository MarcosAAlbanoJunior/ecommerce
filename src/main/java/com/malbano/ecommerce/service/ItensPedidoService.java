package com.malbano.ecommerce.service;

import com.malbano.ecommerce.dto.request.ItensPedidoRequest;
import com.malbano.ecommerce.dto.response.ItensPedidoResponse;
import com.malbano.ecommerce.dto.response.PedidoResponse;
import com.malbano.ecommerce.dto.response.ProdutoEmPedidoResponse;
import com.malbano.ecommerce.exception.NotFoundException;
import com.malbano.ecommerce.mapper.ItensPedidoMapper;
import com.malbano.ecommerce.model.ItensPedido;
import com.malbano.ecommerce.model.Produto;
import com.malbano.ecommerce.repository.ItensPedidoRepositoy;
import com.malbano.ecommerce.repository.PedidoRepositoy;
import com.malbano.ecommerce.repository.ProdutoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service

public class ItensPedidoService {

    @Autowired
    private ItensPedidoRepositoy repositoy;

    @Autowired
    private PedidoRepositoy pedidoRepositoy;

    @Autowired
    private ProdutoRepositoy produtoRepositoy;
    @Autowired
    private ItensPedidoMapper itensPedidoMapper;

    @Transactional
    public void cadastrar(ItensPedidoRequest request) {

        pedidoRepositoy.findById(request.getPedido().getId())
                .orElseThrow(()-> new NotFoundException("Pedido não encontrado"));

        Produto produto = produtoRepositoy.findById(request.getProduto().getId())
                .orElseThrow(()-> new NotFoundException("Produto não encontrado"));

        repositoy.salvarItemPedido(request.getPedido().getId(),
                request.getProduto().getId(),
                request.getQuantidade(), produto.getPreco());
    }

    @Transactional
    public void atualizarQuantidade(Integer id, ItensPedidoRequest request) {

        repositoy.findByPedidoIdAndProdutoId(id, request.getProduto().getId()).orElseThrow(() -> new NotFoundException("Associação de item em Pedido não encontrado"));

        repositoy.atualizarProdutoQuantidadePedido(id, request.getProduto().getId(), request.getQuantidade());
    }

    public ItensPedidoResponse getPedidoById(Integer id){

        List<ItensPedido> lista = repositoy.findByPedidoId(id);

        List<ProdutoEmPedidoResponse> produtoEmPedidoResponse = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for (ItensPedido x : lista){
            produtoEmPedidoResponse.add(itensPedidoMapper.entityToProdutoResponse(x));
            BigDecimal quantidade = new BigDecimal(x.getQuantidade());
            BigDecimal subtotal = quantidade.multiply(x.getPrecoProdutoHistorico());

            total = total.add(subtotal);
        }

        PedidoResponse pedidoResponse = ItensPedidoMapper.INSTANCE.entityToPedidoResponse(lista.stream().findFirst().get().getPedido());

        ItensPedidoResponse itensPedidoResponse = new ItensPedidoResponse();

        itensPedidoResponse.setPedidoResponse(pedidoResponse);
        itensPedidoResponse.setProdutos(produtoEmPedidoResponse);
        itensPedidoResponse.setTotal(total);

        return itensPedidoResponse;
    }

    public List<ItensPedido> getAllPedidos() {
        return repositoy.findAll();
    }
}
