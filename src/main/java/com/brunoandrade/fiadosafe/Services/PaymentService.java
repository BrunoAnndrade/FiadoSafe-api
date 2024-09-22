package com.brunoandrade.fiadosafe.Services;

import com.brunoandrade.fiadosafe.Domain.clients.Client;
import com.brunoandrade.fiadosafe.Domain.clients.exceptions.ClientNotFoundException;
import com.brunoandrade.fiadosafe.Domain.payments.Payment;
import com.brunoandrade.fiadosafe.Domain.payments.PaymentDTO;
import com.brunoandrade.fiadosafe.Domain.payments.exception.PaymentNotFoundException;
import com.brunoandrade.fiadosafe.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ClientService clientService;

    public PaymentService(PaymentRepository paymentRepository, ClientService clientService) {
        this.paymentRepository = paymentRepository;
        this.clientService = clientService;
    }

    public Payment insertPayment(PaymentDTO paymentDTO) {
        Client client = this.clientService.getById(paymentDTO.clientId())
                .orElseThrow(PaymentNotFoundException::new);

        Payment newPayment = new Payment(paymentDTO);
        newPayment.setClient(client);

        if (client.getTotalDebt() == null) {
            client.setTotalDebt(0.0);
        }

        this.paymentRepository.save(newPayment);

        clientService.updateClientDebt(client.getId());

        return newPayment;
    }

    public List<Payment> getAllPayments(){
        return this.paymentRepository.findAll();
    }
}
