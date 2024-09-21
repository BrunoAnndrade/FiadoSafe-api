package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, String> {
}
