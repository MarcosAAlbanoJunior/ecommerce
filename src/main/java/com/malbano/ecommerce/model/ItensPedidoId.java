package com.malbano.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ItensPedidoId implements Serializable {
    private static final long serialVersionUID = 3054030889379947740L;
    @Column(name = "pedidoId", nullable = false)
    private Integer pedidoId;

    @Column(name = "produtoId", nullable = false)
    private Integer produtoId;

}