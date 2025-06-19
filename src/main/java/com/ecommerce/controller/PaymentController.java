package com.ecommerce.controller;


import com.ecommerce.entity.Payment;
import com.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentRepository repository;

    @PostMapping("/process")
    public String initiatePayment(@RequestParam Long orderId) {
        Payment payment = repository.save(Payment.builder()
                .orderId(orderId)
                .status("CREATED")
                .build());

        return "Payment initiated for order ID: " + orderId;
    }
}
