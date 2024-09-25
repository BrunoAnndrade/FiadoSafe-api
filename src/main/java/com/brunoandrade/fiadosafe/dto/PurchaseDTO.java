package com.brunoandrade.fiadosafe.dto;

import java.time.LocalDateTime;

public record PurchaseDTO (
        String productName,
        Double price,
        LocalDateTime purchaseDate,
        String clientId
){

}
