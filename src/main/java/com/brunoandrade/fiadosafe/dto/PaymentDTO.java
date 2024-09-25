package com.brunoandrade.fiadosafe.dto;

import java.time.LocalDate;

public record PaymentDTO (
    Double amount,
    LocalDate paymentDate,
    String clientId
){

}
