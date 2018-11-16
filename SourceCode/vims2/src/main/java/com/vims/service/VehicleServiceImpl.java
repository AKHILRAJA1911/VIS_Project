package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.dao.VehicleDao;
import com.vims.model.AccidentClaim;
import com.vims.model.Cancellation;
import com.vims.model.DirectPay;
import com.vims.model.RegisteredPay;
import com.vims.model.TheftClaim;
import com.vims.model.VehicleRegistration;

@Service
public class VehicleServiceImpl implements VehicleService{

	
	@Autowired
	private VehicleDao vehicledao;
	
	@Override
	public List<VehicleRegistration> findByPolicyId(String policy_id) {
		
		return vehicledao.findByPolicyId(policy_id);
	}

	@Override
	public List<VehicleRegistration> findAll() {
		// TODO Auto-generated method stub
		return vehicledao.findAll();
	}

	@Override
	public Optional<VehicleRegistration> findById(String policy_id) {
		// TODO Auto-generated method stub
		return vehicledao.findById(policy_id);
	}

	@Override
	public void deleteById(String policy_id) {
		vehicledao.deleteById(policy_id);
		
	}

	@Override
	public VehicleRegistration save(VehicleRegistration vehicle) {
		// TODO Auto-generated method stub
		return vehicledao.save(vehicle);
	}

	@Override
	public List<DirectPay> getDirectPayDetails(String policy_id) {
		// TODO Auto-generated method stub
		return vehicledao.getDirectPayDetails(policy_id);
	}

	@Override
	public List<RegisteredPay> getRegisteredPayDetails(String policy_id) {
		// TODO Auto-generated method stub
		return vehicledao.getRegisteredPayDetails(policy_id);
	}

	@Override
	public List<TheftClaim> getTheftClaimDetails(String policy_id) {
		// TODO Auto-generated method stub
		return vehicledao.getTheftClaimDetails(policy_id);
	}

	@Override
	public List<AccidentClaim> getAccidentClaimDetails(String policy_id) {
		// TODO Auto-generated method stub
		return vehicledao.getAccidentClaimDetails(policy_id);
	}

	@Override
	public List<Cancellation> getCancellationDetails(String policy_id) {
		// TODO Auto-generated method stub
		return vehicledao.getCancellationDetails(policy_id);
	}

}
