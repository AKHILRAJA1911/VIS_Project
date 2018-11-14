package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.dao.DirectPaydao;
import com.vims.model.DirectPay;
@Service
public class DirectPayServiceImpl implements DirectPayService{

	@Autowired
	private DirectPaydao directpaydao;
	@Override
	public List<DirectPay> findByPaymentId(String payment_id) {
		// TODO Auto-generated method stub
		return directpaydao.findByPaymentId(payment_id);
	}

	@Override
	public List<DirectPay> findAll() {
		// TODO Auto-generated method stub
		return directpaydao.findAll();
	}

	@Override
	public Optional<DirectPay> findById(String payment_id) {
		// TODO Auto-generated method stub
		return directpaydao.findById(payment_id);
	}

	@Override
	public void deleteById(String payment_id) {
		// TODO Auto-generated method stub
		 directpaydao.deleteById(payment_id);
	}

	@Override
	public DirectPay save(DirectPay directpay) {
		// TODO Auto-generated method stub
		return directpaydao.save(directpay);
	}

	@Override
	public String findTotalAmountByCustomerId(String policy_id) {
		// TODO Auto-generated method stub
		return directpaydao.findTotalAmountByPolicyId(policy_id);
	}

	

}
