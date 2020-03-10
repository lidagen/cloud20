package com.ws.springcloud.dao;

import com.ws.springcloud.entites.payment.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    /**
     * 新增
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     *
     * @param id
     * @return
     */
    Payment getById(Long id);


}
