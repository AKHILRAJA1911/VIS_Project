package com.vims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vims.model.AccidentClaim;
import com.vims.model.Cancellation;
import com.vims.model.Customer;
import com.vims.model.TheftClaim;
import com.vims.model.VehicleRegistration;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {
	
	@Query(value="SELECT cr.customer_id from customer_registration cr where cr.username like %:username% and cr.password like %:password%" )
	String findByCustomer(@Param("username") String username,@Param("password") String password);
		
	
	@Query("from vehicle_details vd where vd.customer_id like %:Customer_Id%")
	List<VehicleRegistration> getVehicleDetails(@Param("Customer_Id") String customer_id);
	
	@Query("from theft_claim tc where tc.customer_id like %:Customer_Id%")
	List<TheftClaim> getTheftClaimDetails(@Param("Customer_Id") String customer_id);
	
	@Query("from accident_claim ac where ac.customer_id like %:Customer_Id%")
	List<AccidentClaim> getAccidentClaimDetails(@Param("Customer_Id") String customer_id);
	
	@Query("from cancellation_details cd where cd.customer_id like %:customer_id%")
	List<Cancellation> getCancellationDetails(@Param("customer_id") String customer_id);
}
