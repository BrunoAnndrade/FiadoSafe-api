package com.brunoandrade.fiadosafe.services;

import com.brunoandrade.fiadosafe.domains.clients.Client;
import com.brunoandrade.fiadosafe.domains.payments.Payment;
import com.brunoandrade.fiadosafe.dto.PaymentDTO;
import com.brunoandrade.fiadosafe.domains.payments.PaymentMapper;
import com.brunoandrade.fiadosafe.domains.payments.exception.PaymentNotFoundException;
import com.brunoandrade.fiadosafe.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ClientService clientService;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository, ClientService clientService, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.clientService = clientService;
        this.paymentMapper = paymentMapper;
    }

    public Payment insertPayment(PaymentDTO paymentDTO) {
        Client client = this.clientService.getById(paymentDTO.clientId())
                .orElseThrow(PaymentNotFoundException::new);

        Payment newPayment = new Payment(paymentDTO);
        newPayment.setClient(client);

        if (client.getTotalDebt() == null) {
            client.setTotalDebt(0.0);
        }

        Double currentDebt = client.getTotalDebt() ;
        client.setTotalDebt(currentDebt - newPayment.getAmount());

        this.paymentRepository.save(newPayment);

        clientService.updateClientDebt(client.getId());

        return newPayment;
    }

    public Payment update(String id, PaymentDTO paymentDTO) {
        Payment payment = this.paymentRepository
                .findById(id)
                .orElseThrow(PaymentNotFoundException::new);

        this.clientService.getById(paymentDTO.clientId())
                .ifPresent(payment::setClient);

        paymentMapper.updatePaymentFromDTO(paymentDTO, payment);

        this.paymentRepository.save(payment);

        clientService.updateClientDebt(payment.getClient().getId());

        return payment;
    }

    public void delete(String id) {
        Payment payment = this.paymentRepository
                .findById(id)
                .orElseThrow(PaymentNotFoundException::new);

        this.paymentRepository.delete(payment);
        clientService.updateClientDebt(payment.getClient().getId());
    }



    public List<Payment> getAllPayments(){
        return this.paymentRepository.findAll();
    }
}
