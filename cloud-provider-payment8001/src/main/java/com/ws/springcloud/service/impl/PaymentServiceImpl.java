package com.ws.springcloud.service.impl;

import com.ws.springcloud.dao.PaymentMapper;
import com.ws.springcloud.entites.payment.Payment;
import com.ws.springcloud.exc.AppException;
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
        int result = paymentMapper.create(payment);
        if (result <= 1){
            throw new AppException("插入失败");
        }
        return result;
    }

    @Override
    public Payment getById(Long id) {
        Payment payment = paymentMapper.getById(id);
        if (payment == null){
            throw new AppException("查询为空");
        }
        return payment;
    }
}
