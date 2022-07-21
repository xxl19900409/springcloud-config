package com.payment.service;

import com.entity.domain.Payment;

public interface IPaymentService {

    public int insert(Payment payment);

    public Payment selectPaymentById(Long id);
}
