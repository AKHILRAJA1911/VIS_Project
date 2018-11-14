package com.vims.service;

import java.util.List;
import java.util.Optional;

import com.vims.model.RegisteredPay;

public interface RegisteredPayService {

	public List<RegisteredPay> findByPaymentId(String payment_id);
	public List<RegisteredPay> findAll();
	public  Optional<RegisteredPay> findById(String payment_id);
	void deleteById(String payment_id);
	public RegisteredPay save(RegisteredPay registeredpay);
}
