package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.vims.model.DirectPay;

public interface DirectPayService {

	public List<DirectPay> findByPaymentId(String payment_id);
	public List<DirectPay> findAll();
	public  Optional<DirectPay> findById(String payment_id);
	void deleteById(String payment_id);
	public DirectPay save(DirectPay directpay);
	String findTotalAmountByCustomerId(@Param("customer_id") String customer_id);
}
