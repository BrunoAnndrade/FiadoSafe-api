package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.Domain.payments.Payment;
import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

    @Query("{ 'client.id' : ?0 }")
    List<Payment> findPaymentsByClientId(String clientId);


}
