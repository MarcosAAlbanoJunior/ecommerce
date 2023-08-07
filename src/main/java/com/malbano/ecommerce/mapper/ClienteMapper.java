package com.malbano.ecommerce.mapper;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import com.malbano.ecommerce.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    public abstract Cliente requestToEntity(ClienteRequest request);
}
