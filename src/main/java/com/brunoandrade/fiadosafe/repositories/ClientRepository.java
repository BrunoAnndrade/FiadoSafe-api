package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.Domain.clients.Client;
import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    
}
