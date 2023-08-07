package com.malbano.ecommerce.repository;

import com.malbano.ecommerce.model.ItensPedido;
import com.malbano.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItensPedidoRepositoy extends JpaRepository<ItensPedido, Integer> {

    @Modifying
    @Query(value = "INSERT INTO itenspedidos (pedido_id, produto_id, quantidade, preco_produto_historico)" +
            " VALUES (:pedidoId, :produtoId, :quantidade, :precoProduto)", nativeQuery = true)
    void salvarItemPedido(Integer pedidoId, Integer produtoId, Integer quantidade, BigDecimal precoProduto);

    List<ItensPedido> findByPedidoId(Integer pedidoId);

    Optional<ItensPedido> findByPedidoIdAndProdutoId(Integer pedidoId, Integer produtoId);
    @Modifying
    @Query(value = "UPDATE itenspedidos i SET i.quantidade = :quantidade " +
            "WHERE i.pedido_id = :pedidoId AND i.produto_id = :produtoId", nativeQuery = true)
    void atualizarProdutoQuantidadePedido(Integer pedidoId, Integer produtoId, Integer quantidade);
}
