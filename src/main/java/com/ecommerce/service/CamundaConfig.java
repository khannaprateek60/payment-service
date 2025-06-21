package com.ecommerce.service;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaConfig {

    @Bean
    public JavaDelegate simulatePayment() {
        return execution -> {
            // Simulate external payment processing
            //System.out.println("Processing payment for order: " + execution.getVariable("orderId"));
            execution.setVariable("approved", true);
        };
    }
}
