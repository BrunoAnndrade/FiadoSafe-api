package com.brunoandrade.fiadosafe.Domain.payments;

import java.time.LocalDate;

public record PaymentDTO (
    Double amount,
    LocalDate paymentDate,
    String clientId
){

}
