package com.brunoandrade.fiadosafe.Services;

import com.brunoandrade.fiadosafe.Domain.clients.Client;
import com.brunoandrade.fiadosafe.Domain.clients.ClientDTO;
import com.brunoandrade.fiadosafe.Domain.clients.ClientMapper;
import com.brunoandrade.fiadosafe.Domain.clients.exceptions.ClientNotFoundException;
import com.brunoandrade.fiadosafe.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public Client insert(ClientDTO clientData){
        Client newClient = new Client(clientData);

        this.clientRepository.save(newClient);

        return newClient;
    }

    public List<Client> getAll(){
        return this.clientRepository.findAll();
    }

    public Optional<Client> getById(String id) {
        return this.clientRepository.findById(id);
    }

    public Client update(String id, ClientDTO clientData){
        Client client = this.clientRepository
                .findById(id)
                .orElseThrow(ClientNotFoundException::new);

        clientMapper.updateClientFromDTO(clientData, client);

        this.clientRepository.save(client);

        return client;
    }

    public void delete(String id){
        Client client = this.clientRepository
                .findById(id)
                .orElseThrow(ClientNotFoundException::new);

        this.clientRepository.delete(client);
    }
}
