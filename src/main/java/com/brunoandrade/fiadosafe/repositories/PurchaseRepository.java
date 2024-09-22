package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, String> {

    @Query(value = "{ 'client.id' : ?0 }", fields = "{ 'price' : 1 }")
    List<Purchase> findAllByClientId(String clientId);
}
