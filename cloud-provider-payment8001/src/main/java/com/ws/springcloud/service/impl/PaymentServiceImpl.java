package com.ws.springcloud.service.impl;

import com.ws.springcloud.dao.PaymentMapper;
import com.ws.springcloud.entites.payment.Payment;
import com.ws.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * USER: wang_s
 * DATE：2020/3/8
 * DESC：
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentMapper.getById(id);
    }
}
