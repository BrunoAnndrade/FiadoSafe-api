package com.brunoandrade.fiadosafe.domains.payments;

import com.brunoandrade.fiadosafe.domains.clients.Client;
import com.brunoandrade.fiadosafe.dto.PaymentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "payments")
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    private String id;
    private Double amount;
    private LocalDate paymentDate;
    private Client client;

    public Payment(PaymentDTO data) {
        this.amount = data.amount();
        this.paymentDate = data.paymentDate();
    }
}
