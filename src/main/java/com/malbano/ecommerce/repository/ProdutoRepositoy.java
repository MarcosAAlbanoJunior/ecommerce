package com.malbano.ecommerce.repository;

import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProdutoRepositoy extends JpaRepository<Produto, Integer> {

    @Modifying
    @Query("UPDATE Produto p SET p.nomeProduto = :novoNome, p.preco = :novoPreco WHERE p.id = :id")
    void updateProdutoById(Integer id, String novoNome, BigDecimal novoPreco);

    @Modifying
    @Query("UPDATE Produto p SET p.preco = :novoPreco WHERE p.id = :id")
    void updatePrecoProdutoById(Integer id, BigDecimal novoPreco);
}
