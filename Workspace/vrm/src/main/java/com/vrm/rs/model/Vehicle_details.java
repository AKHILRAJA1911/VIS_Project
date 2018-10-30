package com.vrm.rs.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Vehicle Details.")

public class Vehicle_details implements Serializable{
	
	private static final long serialVersionUID = -7788619177798333712L;
	
	
	@ApiModelProperty(notes = "Unique Id of the policy.", required = true)
	private String policy_id;
	@ApiModelProperty(notes = "Name of the Vehicle Owner.", required = true)
	private String Vehicle_Owner;
	@ApiModelProperty(notes = "vehicle state.", required = true)
	private String Vehicle_Registration_State;
	@ApiModelProperty(notes = "Vehicle type.", required = true)
	private String Vehicle_Type;
	@ApiModelProperty(notes = "Name of the class.", required = true)
	private String Vehicle_Class;
	@ApiModelProperty(notes = "Name of the Manufacturer.", required = true)
	private String Manufacturer;
	@ApiModelProperty(notes = "Name of the model.", required = true)
	private String Model;
	@ApiModelProperty(notes = "Engine Number.", required = true)
	private String Engine_Number;
	@ApiModelProperty(notes = "Vehicle make year.", required = true)
	private int Make_Year;
	@ApiModelProperty(notes = "Vehicle Location.", required = true)
	private String Registering_location;
	@ApiModelProperty(notes = "Date of Purchase.", required = true)
	private Date Date_of_Purchase;
	@ApiModelProperty(notes = "Price of the vehicle.", required = true)
	private double Price;
	@ApiModelProperty(notes = "Total premium amount.", required = true)
	private double Premium_amount;
	
	public String getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}
	public String getVehicle_Owner() {
		return Vehicle_Owner;
	}
	public void setVehicle_Owner(String vehicle_Owner) {
		Vehicle_Owner = vehicle_Owner;
	}
	public String getVehicle_Registration_State() {
		return Vehicle_Registration_State;
	}
	public void setVehicle_Registration_State(String vehicle_Registration_State) {
		Vehicle_Registration_State = vehicle_Registration_State;
	}
	public String getVehicle_Type() {
		return Vehicle_Type;
	}
	public void setVehicle_Type(String vehicle_Type) {
		Vehicle_Type = vehicle_Type;
	}
	public String getVehicle_Class() {
		return Vehicle_Class;
	}
	public void setVehicle_Class(String vehicle_Class) {
		Vehicle_Class = vehicle_Class;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getEngine_Number() {
		return Engine_Number;
	}
	public void setEngine_Number(String engine_Number) {
		Engine_Number = engine_Number;
	}
	public int getMake_Year() {
		return Make_Year;
	}
	public void setMake_Year(int make_Year) {
		Make_Year = make_Year;
	}
	public String getRegistering_location() {
		return Registering_location;
	}
	public void setRegistering_location(String registering_location) {
		Registering_location = registering_location;
	}
	public Date getDate_of_Purchase() {
		return Date_of_Purchase;
	}
	public void setDate_of_Purchase(Date date_of_Purchase) {
		Date_of_Purchase = date_of_Purchase;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getPremium_amount() {
		return Premium_amount;
	}
	public void setPremium_amount(double premium_amount) {
		Premium_amount = premium_amount;
	}
	
	
	

	
	
	
	
	
}
