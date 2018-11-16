package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.dao.RegisteredPaydao;
import com.vims.model.RegisteredPay;
@Service
public class RegisteredPayServiceImpl implements RegisteredPayService{

	@Autowired
	private RegisteredPaydao registeredpaydao;
	@Override
	public List<RegisteredPay> findByPaymentId(String payment_id) {
		// TODO Auto-generated method stub
		return registeredpaydao.findByPaymentId(payment_id);
	}

	@Override
	public List<RegisteredPay> findAll() {
		// TODO Auto-generated method stub
		return registeredpaydao.findAll();
	}


	@Override
	public void deleteById(String payment_id) {
		// TODO Auto-generated method stub
		registeredpaydao.deleteById(payment_id);
	}

	@Override
	public RegisteredPay save(RegisteredPay registeredpay) {
		// TODO Auto-generated method stub
		return registeredpaydao.save(registeredpay);
	}

	@Override
	public Optional<RegisteredPay> findById(String payment_id) {
		// TODO Auto-generated method stub
		return registeredpaydao.findById(payment_id);
	}

	

}
