package com.malbano.ecommerce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItensPedidoResponse {
    private PedidoResponse pedidoResponse;

    private List<ProdutoEmPedidoResponse> produtos;

    private BigDecimal total;

}
