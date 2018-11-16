package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.dao.CustomerDao;
import com.vims.model.AccidentClaim;
import com.vims.model.Cancellation;
import com.vims.model.Customer;
import com.vims.model.TheftClaim;
import com.vims.model.VehicleRegistration;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao custdao;
	
	
	
//	@Override
//	public Optional<Customer> findByCustomerId(String customer_id) {
//		
//		return custdao.findByCustomerId(customer_id);
//		
//	}

	@Override
	public List<Customer> findAll() {
		
		return custdao.findAll();
	}

	@Override
	public Optional<Customer> findById(String customer_id) {
	
		return custdao.findById(customer_id);
	}

	@Override
	public void deleteById(String customer_id) {
		custdao.deleteById(customer_id);
		
	}

	@Override
	public Customer save(Customer customer) {
	
		return custdao.save(customer);
	}

	@Override
	public String findByCustomer(String username, String password) {
		// TODO Auto-generated method stub
		return custdao.findByCustomer(username, password);
	}

	@Override
	public List<VehicleRegistration> getVehicleDetails(String customer_id) {
		// TODO Auto-generated method stub
		return custdao.getVehicleDetails(customer_id);
	}

	@Override
	public List<Cancellation> getCancellationDetails(String policy_id) {
		// TODO Auto-generated method stub
		return custdao.getCancellationDetails(policy_id);
	}

	@Override
	public List<AccidentClaim> getAccidentClaimDetails(String customer_id) {
		// TODO Auto-generated method stub
		return custdao.getAccidentClaimDetails(customer_id);
	}

	@Override
	public List<TheftClaim> getTheftClaimDetails(String customer_id) {
		// TODO Auto-generated method stub
		return custdao.getTheftClaimDetails(customer_id);
	}

}
