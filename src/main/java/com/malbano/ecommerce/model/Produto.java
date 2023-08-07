package com.malbano.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nomeProduto", nullable = false)
    private String nomeProduto;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

}