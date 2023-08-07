package com.malbano.ecommerce.service;

import com.malbano.ecommerce.dto.request.ProdutoRequest;
import com.malbano.ecommerce.exception.NotFoundException;
import com.malbano.ecommerce.mapper.ClienteMapper;
import com.malbano.ecommerce.mapper.ProdutoMapper;
import com.malbano.ecommerce.model.Produto;
import com.malbano.ecommerce.repository.ClienteRepositoy;
import com.malbano.ecommerce.repository.ProdutoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ProdutoService {

    @Autowired
    private ProdutoRepositoy repositoy;

    @Transactional
    public Produto cadastrar(ProdutoRequest request) {

        return  repositoy.saveAndFlush(ProdutoMapper.INSTANCE.requestToEntity(request));
    }

    @Transactional
    public void atualizar(Integer id, ProdutoRequest request) {

        repositoy.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        Produto produto = ProdutoMapper.INSTANCE.requestToEntity(request);

        repositoy.updateProdutoById(id, produto.getNomeProduto(), produto.getPreco());
    }

    @Transactional
    public void atualizarPreco(Integer id, ProdutoRequest request) {

        repositoy.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        Produto produto = ProdutoMapper.INSTANCE.requestToEntity(request);

        repositoy.updatePrecoProdutoById(id, produto.getPreco());
    }

    public Produto getProdutoById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Produto> getAllProdutos() {
        return repositoy.findAll();
    }
}
