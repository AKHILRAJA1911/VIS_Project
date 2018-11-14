package com.vims.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="vehicle_details")
@GenericGenerator(name="policyid",strategy="com.vims.generators.PolicyIdGenerator")
public class VehicleRegistration {

	
	@Id
	@GeneratedValue(generator="policyid")
	private String policy_id;
	private String vehicle_owner;
	private String vehicle_state;
	private String vehicle_type;
	private String manufacturer;
	private String model;
	private String vehicle_class;
	private String engine_number;
	private String make_year;
	private String registering_location;
	private Date date_of_purchase;
	private String price;
	private String premium_amount;
	private Date maturity_date;
	
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}

	private String customer_id;
	//private String policy_id;
	
	public VehicleRegistration(String policy_id, String vehicle_owner, String vehicle_state, String vehicle_type,
			String manufacturer, String model, String vehicle_class, String engine_number, String make_year,
			String registering_location, Date date_of_purchase, String price, String premium_amount, Customer cust) {
		super();
		this.policy_id = policy_id;
		this.vehicle_owner = vehicle_owner;
		this.vehicle_state = vehicle_state;
		this.vehicle_type = vehicle_type;
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicle_class = vehicle_class;
		this.engine_number = engine_number;
		this.make_year = make_year;
		this.registering_location = registering_location;
		this.date_of_purchase = date_of_purchase;
		this.price = price;
		this.premium_amount = premium_amount;
		//this.cust = cust;
	}
	
	public String getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}
	public String getVehicle_owner() {
		return vehicle_owner;
	}
	public void setVehicle_owner(String vehicle_owner) {
		this.vehicle_owner = vehicle_owner;
	}
	public String getVehicle_state() {
		return vehicle_state;
	}
	public void setVehicle_state(String vehicle_state) {
		this.vehicle_state = vehicle_state;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVehicle_class() {
		return vehicle_class;
	}
	public void setVehicle_class(String vehicle_class) {
		this.vehicle_class = vehicle_class;
	}
	public String getEngine_number() {
		return engine_number;
	}
	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}
	public String getMake_year() {
		return make_year;
	}
	public void setMake_year(String make_year) {
		this.make_year = make_year;
	}
	public String getRegistering_location() {
		return registering_location;
	}
	public void setRegistering_location(String registering_location) {
		this.registering_location = registering_location;
	}
	public Date getDate_of_purchase() {
		return date_of_purchase;
	}
	public void setDate_of_purchase(Date date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPremium_amount() {
		return premium_amount;
	}
	public void setPremium_amount(String premium_amount) {
		this.premium_amount = premium_amount;
	}
	
	
	public VehicleRegistration() {
		
	}
	
	
	
	
	
	
}
