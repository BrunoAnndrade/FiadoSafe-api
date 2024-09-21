package com.brunoandrade.fiadosafe.Domain.purchases;

import com.brunoandrade.fiadosafe.Domain.clients.Client;
import com.brunoandrade.fiadosafe.Domain.clients.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    void updatePurchaseFromDTO(PurchaseDTO dto, @MappingTarget Purchase purchase);
}
