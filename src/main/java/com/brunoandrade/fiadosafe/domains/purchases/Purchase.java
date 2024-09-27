package com.brunoandrade.fiadosafe.domains.purchases;

import com.brunoandrade.fiadosafe.domains.clients.Client;
import com.brunoandrade.fiadosafe.dto.PurchaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "purchases")
@Getter
@Setter
@NoArgsConstructor
public class Purchase {

    @Id
    private String id;
    private String productName;
    private Double price;
    private LocalDateTime dateOfPurchase;
    private Client client;

    public Purchase(PurchaseDTO data) {
        this.productName = data.productName();
        this.price = data.price();
        this.dateOfPurchase = LocalDateTime.now();
    }
}
