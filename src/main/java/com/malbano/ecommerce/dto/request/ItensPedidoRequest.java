package com.malbano.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItensPedidoRequest {

    private ItensPedidoIdRequest id;

    private PedidoRequest pedido;

    private ProdutoRequest produto;

    private Integer quantidade;

}
