package com.vrm.rs.service;

import java.util.List;

import com.vrm.rs.model.Vehicle_details;

public interface VehicleService {

	public List<Vehicle_details> getAllVehicles();
	public List<Vehicle_details> getVehicleBySearchTerm(String searchTerm);
	//public List<Vehicle_details> updateVehicleBySearchTerm(String searchTerm);
	
	
	
}
