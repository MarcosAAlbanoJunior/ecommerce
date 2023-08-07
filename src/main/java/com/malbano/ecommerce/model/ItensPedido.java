package com.malbano.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "itenspedidos")
public class ItensPedido {
    @EmbeddedId
    private ItensPedidoId id;

    @MapsId("pedidoId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pedidoId", nullable = false)
    private Pedido pedido;

    @MapsId("produtoId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "produtoId", nullable = false)
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco_produto_historico")
    private BigDecimal precoProdutoHistorico;


}