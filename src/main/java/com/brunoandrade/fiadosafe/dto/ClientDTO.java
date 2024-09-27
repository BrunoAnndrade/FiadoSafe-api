package com.brunoandrade.fiadosafe.dto;

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
        Double totalDebt
) {}
