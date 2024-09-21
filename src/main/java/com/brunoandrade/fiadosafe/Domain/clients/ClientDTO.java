package com.brunoandrade.fiadosafe.Domain.clients;

import com.brunoandrade.fiadosafe.Domain.payments.Payment;
import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;

import java.util.List;

public record ClientDTO(
        String name,
        String email,
        String address,
        String city,
        String state,
        String country,
        String phoneNumber,
        String age,
        String gender,
        List<Purchase> purchaseList,
        List<Payment> paymentList,
        Double totalDebt
) {
}
