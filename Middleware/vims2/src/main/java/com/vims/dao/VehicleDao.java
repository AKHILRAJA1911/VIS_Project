package com.vims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vims.model.AccidentClaim;
import com.vims.model.Cancellation;
import com.vims.model.DirectPay;
import com.vims.model.RegisteredPay;
import com.vims.model.TheftClaim;
import com.vims.model.VehicleRegistration;

public interface VehicleDao extends JpaRepository<VehicleRegistration, String>{

	@Query("from vehicle_details vd where vd.policy_id like %:policy_id%")
	List<VehicleRegistration> findByPolicyId(@Param("policy_id") String policy_id);
		
	@Query("from direct_pay dp where dp.vehicle.policy_id like %:policy_id%")
	List<DirectPay> getDirectPayDetails(@Param("policy_id") String policy_id);
	
	@Query("from registered_pay rp where rp.vehicle.policy_id like %:policy_id%")
	List<RegisteredPay> getRegisteredPayDetails(@Param("policy_id") String policy_id);
	
	@Query("from theft_claim tc where tc.vehicle.policy_id like %:policy_id%")
	List<TheftClaim> getTheftClaimDetails(@Param("policy_id") String policy_id);
	
	@Query("from accident_claim ac where ac.vehicle.policy_id like %:policy_id%")
	List<AccidentClaim> getAccidentClaimDetails(@Param("policy_id") String policy_id);
	
	@Query("from cancellation_details cd where cd.vehicle.policy_id like %:policy_id%")
	List<Cancellation> getCancellationDetails(@Param("policy_id") String policy_id);
	
}
