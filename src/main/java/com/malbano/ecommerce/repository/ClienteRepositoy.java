package com.malbano.ecommerce.repository;

import com.malbano.ecommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {

    @Modifying
    @Query("UPDATE Cliente c SET c.nome = :novoNome, c.email = :novoEmail WHERE c.id = :id")
    void updateClienteById(Long id, String novoNome, String novoEmail);
}
