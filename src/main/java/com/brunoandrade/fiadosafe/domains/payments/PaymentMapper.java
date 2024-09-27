package com.brunoandrade.fiadosafe.domains.payments;

import com.brunoandrade.fiadosafe.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    void updatePaymentFromDTO(PaymentDTO paymentDTO, @MappingTarget Payment payment);
}
