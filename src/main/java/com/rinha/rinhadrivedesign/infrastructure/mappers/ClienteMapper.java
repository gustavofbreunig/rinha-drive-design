package com.rinha.rinhadrivedesign.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente paraCliente(ClienteEntity entity);
    ClienteEntity paraClienteEntity(Cliente cliente);
}
