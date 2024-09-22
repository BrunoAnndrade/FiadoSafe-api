package com.brunoandrade.fiadosafe.Domain.payments.exception;

import com.brunoandrade.fiadosafe.Domain.payments.Payment;
import com.brunoandrade.fiadosafe.Domain.payments.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    void updatePaymentFromDTO(PaymentDTO paymentDTO, @MappingTarget Payment payment);
}
