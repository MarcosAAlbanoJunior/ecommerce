package com.malbano.ecommerce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEmPedidoResponse {

    private Integer id;

    private String nomeProduto;

    private BigDecimal preco;

    private Integer quantidade;

}
