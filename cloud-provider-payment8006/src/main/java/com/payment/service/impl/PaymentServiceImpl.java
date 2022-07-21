package com.payment.service.impl;

import com.entity.domain.Payment;
import com.payment.dao.PaymentDAO;
import com.payment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentServiceImpl
 * @Descrption TODO
 * @date 2022/7/12 16:57
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    public int insert(Payment payment) {
        return paymentDAO.insert(payment);
    }

    @Override
    public Payment selectPaymentById(Long id) {
        return paymentDAO.selectPaymentById(id);
    }
}
