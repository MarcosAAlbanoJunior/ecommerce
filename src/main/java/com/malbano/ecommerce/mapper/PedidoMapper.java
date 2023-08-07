package com.malbano.ecommerce.mapper;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import com.malbano.ecommerce.dto.request.PedidoRequest;
import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PedidoMapper {

    public static final PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
    public abstract Pedido requestToEntity(PedidoRequest request);
}
