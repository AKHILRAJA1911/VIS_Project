package com.vims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vims.model.TheftClaim;

public interface TheftClaimdao extends JpaRepository<TheftClaim, String>{

	@Query("from theft_claim tc where tc.claim_id like %:claim_id%")
	List<TheftClaim> findByClaimId(@Param("claim_id") String claim_id);
	
}
