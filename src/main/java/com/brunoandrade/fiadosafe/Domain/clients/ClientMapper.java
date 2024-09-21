package com.brunoandrade.fiadosafe.Domain.clients;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    void updateClientFromDTO(ClientDTO dto, @MappingTarget Client client);
}
