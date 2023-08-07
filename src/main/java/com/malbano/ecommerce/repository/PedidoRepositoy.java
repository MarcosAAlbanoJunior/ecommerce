package com.malbano.ecommerce.repository;

import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PedidoRepositoy extends JpaRepository<Pedido, Integer> {

    @Modifying
    @Query(value = "UPDATE pedidos p SET p.data_pedido = :novaDataPedido," +
            " p.cliente_id = :cliente WHERE p.id = :id", nativeQuery = true)
    void updatePedidoById(Integer id, LocalDate novaDataPedido, Long cliente);

    @Modifying
    @Query(value = "INSERT pedidos (data_pedido, cliente_id) VALUES (now(), :cliente)", nativeQuery = true)
    void salvarPedido(Long cliente);

}
