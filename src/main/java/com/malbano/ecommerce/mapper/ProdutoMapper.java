package com.malbano.ecommerce.mapper;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import com.malbano.ecommerce.dto.request.ProdutoRequest;
import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProdutoMapper {

    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);
    public abstract Produto requestToEntity(ProdutoRequest request);
}
