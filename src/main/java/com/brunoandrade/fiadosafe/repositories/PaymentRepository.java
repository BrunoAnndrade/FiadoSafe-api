package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.Domain.payments.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
}
