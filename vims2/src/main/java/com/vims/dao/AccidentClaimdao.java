package com.vims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vims.model.AccidentClaim;
import com.vims.model.RegisteredPay;

public interface AccidentClaimdao extends JpaRepository<AccidentClaim, String>{

	@Query("from accident_claim ac where ac.claim_id like %:claim_id%")
	List<AccidentClaim> findByClaimId(@Param("claim_id") String claim_id);
	
}
