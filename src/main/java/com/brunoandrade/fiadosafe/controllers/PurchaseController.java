package com.brunoandrade.fiadosafe.controllers;

import com.brunoandrade.fiadosafe.Domain.purchases.Purchase;
import com.brunoandrade.fiadosafe.Domain.purchases.PurchaseDTO;
import com.brunoandrade.fiadosafe.Services.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> insert(@RequestBody PurchaseDTO purchaseData) {
        Purchase newPurchase = this.purchaseService.insert(purchaseData);
        return ResponseEntity.ok().body(newPurchase);
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAll() {
        List<Purchase> purchaseList = this.purchaseService.getAll();
        return ResponseEntity.ok().body(purchaseList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Purchase> update(@PathVariable("id") String id, @RequestBody PurchaseDTO purchaseData) {
        Purchase updatedPurchase = this.purchaseService.update(id, purchaseData);
        return ResponseEntity.ok().body(updatedPurchase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Purchase> delete(@PathVariable("id") String id) {
        this.purchaseService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
