package com.brunoandrade.fiadosafe.services;

import com.brunoandrade.fiadosafe.domains.clients.Client;
import com.brunoandrade.fiadosafe.dto.ClientDTO;
import com.brunoandrade.fiadosafe.domains.clients.ClientMapper;
import com.brunoandrade.fiadosafe.domains.clients.exceptions.ClientNotFoundException;
import com.brunoandrade.fiadosafe.domains.payments.Payment;
import com.brunoandrade.fiadosafe.domains.purchases.Purchase;
import com.brunoandrade.fiadosafe.repositories.ClientRepository;
import com.brunoandrade.fiadosafe.repositories.PaymentRepository;
import com.brunoandrade.fiadosafe.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final PurchaseRepository purchaseRepository;
    private final PaymentRepository paymentRepository;

    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, PurchaseRepository purchaseRepository, PaymentRepository paymentRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.purchaseRepository = purchaseRepository;
        this.paymentRepository = paymentRepository;
        this.clientMapper = clientMapper;
    }

    public Client insert(ClientDTO clientData) {
        Client newClient = new Client(clientData);

        this.clientRepository.save(newClient);

        return newClient;
    }

    public List<Client> getAll() {
        return this.clientRepository.findAll();
    }

    public Optional<Client> getById(String id) {
        return this.clientRepository.findById(id);
    }

    public Client update(String id, ClientDTO clientData) {
        Client client = this.clientRepository
                .findById(id)
                .orElseThrow(ClientNotFoundException::new);

        clientMapper.updateClientFromDTO(clientData, client);

        this.clientRepository.save(client);

        return client;
    }

    public void delete(String id) {
        Client client = this.clientRepository
                .findById(id)
                .orElseThrow(ClientNotFoundException::new);

        this.clientRepository.delete(client);
    }

    public Double calculateTotalDebt(String clientId) {
        List<Payment> payments = paymentRepository.findPaymentsByClientId(clientId);
        List<Purchase> purchases = purchaseRepository.findPurchasesByClientId(clientId);

        double totalPayments = payments.stream().mapToDouble(Payment::getAmount).sum();
        double totalPurchases = purchases.stream().mapToDouble(Purchase::getPrice).sum();

        return totalPurchases - totalPayments;
    }


    public void updateClientDebt(String clientId) {
        Double totalDebt = calculateTotalDebt(clientId);
        Client client = clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        client.setTotalDebt(totalDebt);
        clientRepository.save(client);
    }
}
