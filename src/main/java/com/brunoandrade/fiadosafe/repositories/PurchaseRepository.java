package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.domains.purchases.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, String> {

    @Query("{ 'client.id' : ?0 }")
    List<Purchase> findPurchasesByClientId(String clientId);


}
