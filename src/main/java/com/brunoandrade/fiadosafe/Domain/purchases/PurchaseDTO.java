package com.brunoandrade.fiadosafe.Domain.purchases;

import java.time.LocalDateTime;

public record PurchaseDTO (
        String productName,
        Double price,
        LocalDateTime purchaseDate,
        String clientId,
        String productId
){

}
