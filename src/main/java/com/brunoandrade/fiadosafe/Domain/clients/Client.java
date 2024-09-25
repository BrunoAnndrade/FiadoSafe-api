package com.brunoandrade.fiadosafe.Domain.clients;

import com.brunoandrade.fiadosafe.dto.ClientDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
        this.totalDebt = clientDTO.totalDebt();
    }
}
