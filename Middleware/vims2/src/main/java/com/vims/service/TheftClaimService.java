package com.vims.service;

import java.util.List;
import java.util.Optional;

import com.vims.model.DirectPay;
import com.vims.model.TheftClaim;

public interface TheftClaimService {

	public List<TheftClaim> findByClaimId(String claim_id);
	public List<TheftClaim> findAll();
	public  Optional<TheftClaim> findById(String claim_id);
	void deleteById(String claim_id);
	public TheftClaim save(TheftClaim tc);
}
