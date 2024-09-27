package com.brunoandrade.fiadosafe.controllers;

import com.brunoandrade.fiadosafe.domains.purchases.Purchase;
import com.brunoandrade.fiadosafe.dto.PurchaseDTO;
import com.brunoandrade.fiadosafe.services.PurchaseService;
import com.brunoandrade.fiadosafe.infra.security.SecurityConfigurations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Operation(summary = "Insert new purchase", description = "Inserts a new purchase into the database based on the provided PurchaseDTO data.")
    @ApiResponse(responseCode = "200", description = "Purchase successfully inserted and returned in the response body")
    @ApiResponse(responseCode = "400", description = "Bad request, possibly due to invalid data")
    @PostMapping
    public ResponseEntity<Purchase> insert(@RequestBody PurchaseDTO purchaseData) {
        Purchase newPurchase = this.purchaseService.insert(purchaseData);
        return ResponseEntity.ok().body(newPurchase);
    }

    @Operation(summary = "Retrieve all purchases", description = "Returns a list of all purchases stored in the database.")
    @ApiResponse(responseCode = "200", description = "List of purchases retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No purchases found in the database")
    @GetMapping
    public ResponseEntity<List<Purchase>> getAll() {
        List<Purchase> purchaseList = this.purchaseService.getAll();
        return ResponseEntity.ok().body(purchaseList);
    }

    @Operation(summary = "Update existing purchase", description = "Updates an existing purchase based on the provided PurchaseDTO data and purchase ID.")
    @ApiResponse(responseCode = "200", description = "Purchase successfully updated")
    @ApiResponse(responseCode = "404", description = "Purchase not found")
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> update(@PathVariable("id") String id, @RequestBody PurchaseDTO purchaseData) {
        Purchase updatedPurchase = this.purchaseService.update(id, purchaseData);
        return ResponseEntity.ok().body(updatedPurchase);
    }

    @Operation(summary = "Delete purchase", description = "Deletes an existing purchase from the database based on the provided purchase ID.")
    @ApiResponse(responseCode = "204", description = "Purchase successfully deleted")
    @ApiResponse(responseCode = "404", description = "Purchase not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Purchase> delete(@PathVariable("id") String id) {
        this.purchaseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
