package com.ws.springcloud.service;

import com.ws.springcloud.entites.payment.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getById(Long id);
}
