package com.brunoandrade.fiadosafe.controllers;

import com.brunoandrade.fiadosafe.domains.payments.Payment;
import com.brunoandrade.fiadosafe.dto.PaymentDTO;
import com.brunoandrade.fiadosafe.services.PaymentService;
import com.brunoandrade.fiadosafe.infra.security.SecurityConfigurations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "Insert new payment", description = "Inserts a new payment into the database based on the provided PaymentDTO data.")
    @ApiResponse(responseCode = "200", description = "Payment successfully inserted and returned in the response body")
    @ApiResponse(responseCode = "400", description = "Bad request, possibly due to invalid data")
    @PostMapping
    public ResponseEntity<Payment> insertPayment(@RequestBody PaymentDTO paymentData) {
        Payment newPayment = this.paymentService.insertPayment(paymentData);
        return ResponseEntity.ok().body(newPayment);
    }

    @Operation(summary = "Retrieve all payments", description = "Returns a list of all payments stored in the database.")
    @ApiResponse(responseCode = "200", description = "List of payments retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No payments found in the database")
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> paymentList = this.paymentService.getAllPayments();
        return ResponseEntity.ok().body(paymentList);
    }

    @Operation(summary = "Update existing payment", description = "Updates an existing payment based on the provided PaymentDTO data and payment ID.")
    @ApiResponse(responseCode = "200", description = "Payment successfully updated")
    @ApiResponse(responseCode = "404", description = "Payment not found")
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") String id, @RequestBody PaymentDTO paymentData) {
        Payment updatePayment = this.paymentService.update(id,paymentData);
        return ResponseEntity.ok().body(updatePayment);
    }

    @Operation(summary = "Delete payment", description = "Deletes an existing payment from the database based on the provided payment ID.")
    @ApiResponse(responseCode = "204", description = "Payment successfully deleted")
    @ApiResponse(responseCode = "404", description = "Payment not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") String id) {
        this.paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
