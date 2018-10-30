package com.vrm.rs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrm.rs.dao.VehicleDTO;
import com.vrm.rs.dao.VehicleRepository;
import com.vrm.rs.model.Vehicle_details;


@Service
public class VehicleServiceImpl implements VehicleService{
	
	
	@Autowired
	 DataSource dataSource;
	
	
	@Autowired
	VehicleRepository vehicleRep;

	public List<Vehicle_details> getAllVehicles() {
		
		List<Vehicle_details> list = new ArrayList<Vehicle_details>();
		
		for(VehicleDTO vehicleDto : vehicleRep.getAllVehicles()) {
			Vehicle_details vd=new Vehicle_details();
			vd.setPolicy_id(vehicleDto.getPolicy_id());
			vd.setVehicle_Owner(vehicleDto.getVehicle_Owner());
		    vd.setVehicle_Registration_State(vehicleDto.getVehicle_Registration_State());
		    vd.setVehicle_Type(vehicleDto.getVehicle_Type());
		    vd.setVehicle_Class(vehicleDto.getVehicle_Class());
		    vd.setManufacturer(vehicleDto.getManufacturer());
		    vd.setModel(vehicleDto.getModel());
		    vd.setEngine_Number(vehicleDto.getEngine_Number());
		    vd.setMake_Year(vehicleDto.getMake_Year());
		    vd.setRegistering_location(vehicleDto.getRegistering_location());
		    vd.setDate_of_Purchase(vehicleDto.getDate_of_Purchase());
		    vd.setPrice(vehicleDto.getPrice());
		    vd.setPremium_amount(vehicleDto.getPremium_amount());
			list.add(vd);
			
		
		}
		
		return list;
	}

	public List<Vehicle_details> getVehicleBySearchTerm(String searchTerm) {
		
		List<Vehicle_details> list = new ArrayList<Vehicle_details>();
		
		for(VehicleDTO vehicleDto : vehicleRep.findByPolicy_id(searchTerm)) {
			Vehicle_details vd=new Vehicle_details();
			vehicleDto.getPolicy_id();
			vd.setVehicle_Owner(vehicleDto.getVehicle_Owner());
		    vd.setVehicle_Registration_State(vehicleDto.getVehicle_Registration_State());
		    vd.setVehicle_Type(vehicleDto.getVehicle_Type());
		    vd.setVehicle_Class(vehicleDto.getVehicle_Class());
		    vd.setManufacturer(vehicleDto.getManufacturer());
		    vd.setModel(vehicleDto.getModel());
		    vd.setEngine_Number(vehicleDto.getEngine_Number());
		    vd.setMake_Year(vehicleDto.getMake_Year());
		    vd.setRegistering_location(vehicleDto.getRegistering_location());
		    vd.setDate_of_Purchase(vehicleDto.getDate_of_Purchase());
		    vd.setPrice(vehicleDto.getPrice());
		    vd.setPremium_amount(vehicleDto.getPremium_amount());
			list.add(vd);
		}
		
		return list;
	}

//	public List<Vehicle_details> updateVehicleBySearchTerm(String searchTerm) {
//	
//		
//		return null;
//	}

	

}
