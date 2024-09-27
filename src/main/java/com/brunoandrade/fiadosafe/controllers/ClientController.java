package com.brunoandrade.fiadosafe.controllers;

import com.brunoandrade.fiadosafe.services.ClientService;
import com.brunoandrade.fiadosafe.domains.clients.Client;
import com.brunoandrade.fiadosafe.dto.ClientDTO;
import com.brunoandrade.fiadosafe.infra.security.SecurityConfigurations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Insert new client", description = "Inserts a new client into the database based on the provided ClientDTO data.")
    @ApiResponse(responseCode = "200", description = "Client successfully inserted and returned in the response body")
    @ApiResponse(responseCode = "400", description = "Bad request, possibly due to invalid data")
    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientDTO clientData) {
       Client newClient =  this.clientService.insert(clientData);
       return ResponseEntity.ok().body(newClient);
    }

    @Operation(summary = "Retrieve all clients", description = "Returns a list of all clients stored in the database.")
    @ApiResponse(responseCode = "200", description = "List of clients retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No clients found in the database")
    @GetMapping
    public ResponseEntity<List<Client>> getAll (){
        List<Client> clients = this.clientService.getAll();
        return ResponseEntity.ok().body(clients);
    }

    @Operation(summary = "Update existing client", description = "Updates an existing client based on the provided ClientDTO data and client ID.")
    @ApiResponse(responseCode = "200", description = "Client successfully updated")
    @ApiResponse(responseCode = "404", description = "Client not found")
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id")String id, @RequestBody ClientDTO clientData) {
        Client updatedClient =  this.clientService.update(id, clientData);
        return ResponseEntity.ok().body(updatedClient);
    }

    @Operation(summary = "Delete client", description = "Deletes an existing client from the database based on the provided client ID.")
    @ApiResponse(responseCode = "204", description = "Client successfully deleted")
    @ApiResponse(responseCode = "404", description = "Client not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete (@PathVariable("id") String id) {
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
