package com.malbano.ecommerce.dto.response;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {

    private Integer id;

    private LocalDate dataPedido;

    private ClienteResponse cliente;
}
