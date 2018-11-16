package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.dao.AccidentClaimdao;
import com.vims.model.AccidentClaim;
import com.vims.model.TheftClaim;
@Service
public class AccidentClaimImpl implements AccidentClaimService{
@Autowired 
private AccidentClaimdao acdao;
	@Override
	public List<AccidentClaim> findByClaimId(String claim_id) {
		// TODO Auto-generated method stub
		return acdao.findByClaimId(claim_id);
	}

	@Override
	public List<AccidentClaim> findAll() {
		// TODO Auto-generated method stub
		return acdao.findAll();
	}

	@Override
	public Optional<AccidentClaim> findById(String claim_id) {
		// TODO Auto-generated method stub
		return acdao.findById(claim_id);
	}

	@Override
	public void deleteById(String claim_id) {
		// TODO Auto-generated method stub
		acdao.deleteById(claim_id);
	}

	@Override
	public AccidentClaim save(AccidentClaim ac) {
		// TODO Auto-generated method stub
		return acdao.save(ac);
	}

	

	
}
