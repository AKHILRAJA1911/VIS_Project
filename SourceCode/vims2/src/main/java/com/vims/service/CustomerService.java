package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.vims.model.AccidentClaim;
import com.vims.model.Cancellation;
import com.vims.model.Customer;
import com.vims.model.TheftClaim;
import com.vims.model.VehicleRegistration;
@Service
public interface CustomerService {
	
	
	//public Optional<Customer> findByCustomerId(String customer_id);
	public List<Customer> findAll();
	public  Optional<Customer> findById(String customer_id);
	void deleteById(String customer_id);
	public Customer save(Customer customer);
	String findByCustomer(String username, String password);
	List<VehicleRegistration> getVehicleDetails( String customer_id);
	List<Cancellation>  getCancellationDetails( String policy_id);

	List<AccidentClaim> getAccidentClaimDetails( String customer_id);
	List<TheftClaim> getTheftClaimDetails( String customer_id);
	
}
