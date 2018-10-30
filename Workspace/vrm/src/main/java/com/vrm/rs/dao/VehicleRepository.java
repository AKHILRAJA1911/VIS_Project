package com.vrm.rs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository<VehicleDTO,Long>{
	
	@Query(nativeQuery = true)
	public List<VehicleDTO> findByPolicy_id(@Param("searchTerm") String searchTerm);
	@Query(nativeQuery = true)
	public List<VehicleDTO> getAllVehicles();
//	@Query(nativeQuery = true)
//	public List<VehicleDTO> deleteVehicle(@Param("policyId") String policyId);
//	
	
	

}
