package com.vrm.rs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vrm.rs.dao.VehicleDTO;
import com.vrm.rs.dao.VehicleRepository;
import com.vrm.rs.model.Vehicle_details;
import com.vrm.rs.service.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(VehicleRestURIs.ROOT)
@Api("Operations to manage Vehicles.")

public class VehicleController {

	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	Map<Integer, Vehicle_details> vehicleData = new HashMap<Integer, Vehicle_details>();
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleRepository vehicleRep;
	
	
	@ApiOperation(value="To get the vehicle details based on id provided.",response=Vehicle_details.class)
	@RequestMapping(value=VehicleRestURIs.SEARCH_VEHICLE,method = RequestMethod.GET)
	public List<Vehicle_details> searchVehicle(@PathVariable("searchterm") String searchTerm) {
   		logger.info("Start searchVehicle. searchterm="+searchTerm);
   		List<Vehicle_details> list = vehicleService.getVehicleBySearchTerm(searchTerm);
   		if (list.size()==0) throw new VehicleNotFound(searchTerm);
   		return list;
   		
   	}
	
	
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	 
	 @ApiOperation(value = "View a list of available Vehicles", response = List.class)
		@RequestMapping(value = VehicleRestURIs.GET_ALL_VEHICLES, method = RequestMethod.GET)
		public List getAllEmployees() {
			logger.info("Start getAllVehicles.");	
			System.out.println("get All vehicles Starts");
			List<Vehicle_details>  list = vehicleService.getAllVehicles();
			System.out.println("get All vehicles Ends");
	   		return list;
		}
	
	 @ApiOperation(value = "Create a new Vehicle.", response = Vehicle_details.class)
	    @RequestMapping(value = VehicleRestURIs.CREATE_VEHICLE, method = RequestMethod.POST)
	    public Vehicle_details createVehicle(@RequestBody Vehicle_details vehicle) {
	        logger.info("Start createVehicle.");
	        VehicleDTO vehicleDto = new VehicleDTO();
	        
	        vehicleDto.setVehicle_Owner(vehicle.getVehicle_Owner());
	        vehicleDto.setVehicle_Registration_State(vehicle.getVehicle_Registration_State());
	        vehicleDto.setVehicle_Type(vehicle.getVehicle_Type());
	        vehicleDto.setVehicle_Class(vehicle.getVehicle_Class());
	        vehicleDto.setManufacturer(vehicle.getManufacturer());
	        vehicleDto.setModel(vehicle.getModel());
	        vehicleDto.setEngine_Number(vehicle.getEngine_Number());
	        vehicleDto.setMake_Year(vehicle.getMake_Year());
	        vehicleDto.setRegistering_location(vehicle.getRegistering_location());
	        vehicleDto.setDate_of_Purchase(vehicle.getDate_of_Purchase());
	        vehicleDto.setPrice(vehicle.getPrice());
	        vehicleDto.setPremium_amount(vehicle.getPremium_amount());
	        vehicleRep.save(vehicleDto);
	        return vehicle;
	        

	    }
	
	 @ApiOperation(value = "Update the Vehicle.", response = Vehicle_details.class)
	    @RequestMapping(value = VehicleRestURIs.UPDATE_VEHICLE, method = RequestMethod.PUT)
	    public Vehicle_details updateVehicle(@PathVariable("searchterm") String searchTerm,@RequestBody Vehicle_details vehicle) {
		 for(VehicleDTO vehicleDto : vehicleRep.findByPolicy_id(searchTerm)) {
			 logger.info("Start updateVehicle.");
		        
		       
		        vehicleDto.setVehicle_Owner(vehicle.getVehicle_Owner());
		        vehicleDto.setVehicle_Registration_State(vehicle.getVehicle_Registration_State());
		        vehicleDto.setVehicle_Type(vehicle.getVehicle_Type());
		        vehicleDto.setVehicle_Class(vehicle.getVehicle_Class());
		        vehicleDto.setManufacturer(vehicle.getManufacturer());
		        vehicleDto.setModel(vehicle.getModel());
		        vehicleDto.setEngine_Number(vehicle.getEngine_Number());
		        vehicleDto.setMake_Year(vehicle.getMake_Year());
		        vehicleDto.setRegistering_location(vehicle.getRegistering_location());
		        vehicleDto.setDate_of_Purchase(vehicle.getDate_of_Purchase());
		        vehicleDto.setPrice(vehicle.getPrice());
		        vehicleDto.setPremium_amount(vehicle.getPremium_amount());
		        vehicleRep.save(vehicleDto);
		        
			 
			 
		 }
		return vehicle;
	 
	 }
		 
		 
	public void validateVehicle(String searchTerm) {
		if (vehicleData.get(searchTerm) == null) throw new VehicleNotFound(searchTerm);
	}
}
