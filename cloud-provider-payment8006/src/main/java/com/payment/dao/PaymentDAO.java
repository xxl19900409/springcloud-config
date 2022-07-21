package com.payment.dao;

import com.entity.domain.Payment;

public interface PaymentDAO {

    public int insert(Payment payment);

    public Payment selectPaymentById(Long id);

}
