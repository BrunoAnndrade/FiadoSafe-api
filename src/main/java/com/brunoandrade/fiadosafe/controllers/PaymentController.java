package com.brunoandrade.fiadosafe.controllers;

import com.brunoandrade.fiadosafe.Domain.payments.Payment;
import com.brunoandrade.fiadosafe.Domain.payments.PaymentDTO;
import com.brunoandrade.fiadosafe.Services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> insertPayment(@RequestBody PaymentDTO paymentData) {
        Payment newPayment = this.paymentService.insertPayment(paymentData);
        return ResponseEntity.ok().body(newPayment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> paymentList = this.paymentService.getAllPayments();
        return ResponseEntity.ok().body(paymentList);
    }
}
