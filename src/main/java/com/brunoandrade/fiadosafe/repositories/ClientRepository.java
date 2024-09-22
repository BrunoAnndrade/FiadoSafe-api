package com.brunoandrade.fiadosafe.repositories;

import com.brunoandrade.fiadosafe.Domain.clients.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
