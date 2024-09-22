package com.brunoandrade.fiadosafe.Services;

import com.brunoandrade.fiadosafe.Domain.clients.Client;

import com.brunoandrade.fiadosafe.Domain.clients.exceptions.ClientNotFoundException;
import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;
import com.brunoandrade.fiadosafe.Domain.purchases.PurchaseDTO;
import com.brunoandrade.fiadosafe.Domain.purchases.PurchaseMapper;
import com.brunoandrade.fiadosafe.Domain.purchases.exceptions.PurchaseNotFoundException;
import com.brunoandrade.fiadosafe.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final ClientService clientService;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    public PurchaseService(ClientService clientService, PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper) {
        this.clientService = clientService;
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
    }

    public Purchase insert(PurchaseDTO purchaseData) {
        Client client = this.clientService.getById(purchaseData.clientId())
                .orElseThrow(ClientNotFoundException::new);

        Purchase newPurchase = new Purchase(purchaseData);
        newPurchase.setClient(client);

        if (client.getTotalDebt() == null) {
            client.setTotalDebt(0.0);
        }

        this.purchaseRepository.save(newPurchase);

        clientService.updateClientDebt(client.getId());

        return newPurchase;
    }

    public Purchase update(String id, PurchaseDTO purchaseData) {
        Purchase purchase = this.purchaseRepository
                .findById(id)
                .orElseThrow(PurchaseNotFoundException::new);


        this.clientService.getById(purchaseData.clientId())
                .ifPresent(purchase::setClient);

        purchaseMapper.updatePurchaseFromDTO(purchaseData, purchase);

        this.purchaseRepository.save(purchase);

        clientService.updateClientDebt(purchase.getClient().getId());

        return purchase;
    }

    public void delete(String id) {

        Purchase purchase = this.purchaseRepository
                .findById(id)
                .orElseThrow(PurchaseNotFoundException::new);


        this.purchaseRepository.delete(purchase);

        clientService.updateClientDebt(purchase.getClient().getId());
    }

    public List<Purchase> getAll() {
        return this.purchaseRepository.findAll();
    }
}
