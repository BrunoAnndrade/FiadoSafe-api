package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.domains.payments.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

    @Query("{ 'client.id' : ?0 }")
    List<Payment> findPaymentsByClientId(String clientId);


}
