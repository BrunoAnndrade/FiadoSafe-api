package com.brunoandrade.fiadosafe.infra.repositories;

import com.brunoandrade.fiadosafe.infra.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, String> {

    UserDetails findByLogin(String login);
}
