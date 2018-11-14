package com.vims.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="accident_claim")
@GenericGenerator(name="claimid",strategy="com.vims.generators.ClaimIdGenerator")
public class AccidentClaim {

	@Id
	@GeneratedValue(generator="claimid")
	private String claim_id;
	private String total_amount;
	private String accident_type;
	private String weightage;
	private String claim_amount;
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer cust;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="policy_id")
	private VehicleRegistration vehicle;
	
	

	public AccidentClaim(String claim_id, String total_amount, String accident_type, String weightage,
			String claim_amount, String status, Customer cust, VehicleRegistration vehicle) {
		super();
		this.claim_id = claim_id;
		this.total_amount = total_amount;
		this.accident_type = accident_type;
		this.weightage = weightage;
		this.claim_amount = claim_amount;
		this.status = status;
		this.cust = cust;
		this.vehicle = vehicle;
	}

	public AccidentClaim() {
		
	}

	public String getClaim_id() {
		return claim_id;
	}

	public VehicleRegistration getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleRegistration vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public void setClaim_id(String claim_id) {
		this.claim_id = claim_id;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getAccident_type() {
		return accident_type;
	}

	public void setAccident_type(String accident_type) {
		this.accident_type = accident_type;
	}

	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}

	public String getClaim_amount() {
		return claim_amount;
	}

	public void setClaim_amount(String claim_amount) {
		this.claim_amount = claim_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
