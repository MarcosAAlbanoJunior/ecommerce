package com.malbano.ecommerce.mapper;

import com.malbano.ecommerce.dto.request.ItensPedidoRequest;
import com.malbano.ecommerce.dto.response.ItensPedidoResponse;
import com.malbano.ecommerce.dto.response.PedidoResponse;
import com.malbano.ecommerce.dto.response.ProdutoEmPedidoResponse;
import com.malbano.ecommerce.model.ItensPedido;
import com.malbano.ecommerce.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ItensPedidoMapper {

    public static final ItensPedidoMapper INSTANCE = Mappers.getMapper(ItensPedidoMapper.class);
    public abstract ItensPedido requestToEntity(ItensPedidoRequest request);

    @Mapping(target = "quantidade", source = "quantidade")
    @Mapping(target = "id", source = "produto.id")
    @Mapping(target = "preco", source = "precoProdutoHistorico")
    @Mapping(target = "nomeProduto", source = "produto.nomeProduto")
    public abstract ProdutoEmPedidoResponse entityToProdutoResponse(ItensPedido entity);

    public abstract PedidoResponse entityToPedidoResponse(Pedido entity);

    public abstract ItensPedidoResponse entityToResponse(ItensPedido entity);


}
