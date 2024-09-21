package com.brunoandrade.fiadosafe.Domain.clients;


import com.brunoandrade.fiadosafe.Domain.payments.Payment;
import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    private String id;
    private String name;
    private String email;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phoneNumber;
    private String age;
    private String gender;
    private List<Purchase> purchasesList;
    private List<Payment> paymentsList;
    private Double totalDebt;

    public Client(ClientDTO clientDTO) {
        this.name = clientDTO.name();
        this.email = clientDTO.email();
        this.address = clientDTO.address();
        this.city = clientDTO.city();
        this.state = clientDTO.state();
        this.country = clientDTO.country();
        this.phoneNumber = clientDTO.phoneNumber();
        this.age = clientDTO.age();
        this.gender = clientDTO.gender();
        this.purchasesList = clientDTO.purchaseList();
        this.paymentsList = clientDTO.paymentList();
        this.totalDebt = clientDTO.totalDebt();
    }
}
