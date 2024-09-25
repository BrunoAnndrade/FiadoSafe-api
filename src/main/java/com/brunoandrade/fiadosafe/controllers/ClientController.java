package com.brunoandrade.fiadosafe.controllers;

import com.brunoandrade.fiadosafe.Services.ClientService;
import com.brunoandrade.fiadosafe.Domain.clients.Client;
import com.brunoandrade.fiadosafe.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientDTO clientData) {
       Client newClient =  this.clientService.insert(clientData);
       return ResponseEntity.ok().body(newClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll (){
        List<Client> clients = this.clientService.getAll();
        return ResponseEntity.ok().body(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id")String id, @RequestBody ClientDTO clientData) {
        Client updatedClient =  this.clientService.update(id, clientData);
        return ResponseEntity.ok().body(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete (@PathVariable("id") String id) {
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
