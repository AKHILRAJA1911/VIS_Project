package com.vrm.rs.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Vehicle_details")
@GenericGenerator(name="myId",strategy="com.vrm.rs.dao.IDGenerator")
public class VehicleDTO {
	
	@Id
	@GeneratedValue(generator="myId")
	private String policy_id;
	private String Vehicle_Owner;
	private String Vehicle_Registration_State;
	private String Vehicle_Type;
	private String Vehicle_Class;
	private String Manufacturer;
	private String Model;
	private String Engine_Number;
	private int Make_Year;
	private String Registering_location;
	private Date Date_of_Purchase;
	private double Price;
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



	
	
	
	
	public VehicleDTO(String policy_id, String vehicle_Owner, String vehicle_Registration_State, String vehicle_Type,
			String vehicle_Class, String manufacturer, String model, String engine_Number, int make_Year,
			String registering_location, Date date_of_Purchase, double price, double premium_amount) {
		
		this.policy_id = policy_id;
		this.Vehicle_Owner = vehicle_Owner;
		this.Vehicle_Registration_State = vehicle_Registration_State;
		this.Vehicle_Type = vehicle_Type;
		this.Vehicle_Class = vehicle_Class;
		this.Manufacturer = manufacturer;
		this.Model = model;
		this.Engine_Number = engine_Number;
		this.Make_Year = make_Year;
		this.Registering_location = registering_location;
		this.Date_of_Purchase = date_of_Purchase;
		this.Price = price;
		this.Premium_amount = premium_amount;
	}



	public VehicleDTO() {
		
	}
	
	
	
	
	
	
	

}
