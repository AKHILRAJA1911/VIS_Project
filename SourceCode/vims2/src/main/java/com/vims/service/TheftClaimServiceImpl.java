package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.dao.TheftClaimdao;
import com.vims.model.TheftClaim;

@Service
public class TheftClaimServiceImpl implements TheftClaimService{

	@Autowired
	private TheftClaimdao tcdao;

	@Override
	public List<TheftClaim> findByClaimId(String claim_id) {
		// TODO Auto-generated method stub
		return tcdao.findByClaimId(claim_id);
	}

	@Override
	public List<TheftClaim> findAll() {
		// TODO Auto-generated method stub
		return tcdao.findAll();
	}

	

	@Override
	public void deleteById(String claim_id) {
		// TODO Auto-generated method stub
		tcdao.deleteById(claim_id);
	}

	@Override
	public TheftClaim save(TheftClaim tc) {
		// TODO Auto-generated method stub
		return tcdao.save(tc);
	}

	@Override
	public Optional<TheftClaim> findById(String claim_id) {
		// TODO Auto-generated method stub
		return tcdao.findById(claim_id);
	}
	
}
