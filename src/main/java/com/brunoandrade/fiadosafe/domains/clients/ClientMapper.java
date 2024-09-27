package com.brunoandrade.fiadosafe.domains.clients;

import com.brunoandrade.fiadosafe.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    void updateClientFromDTO(ClientDTO dto, @MappingTarget Client client);
}
