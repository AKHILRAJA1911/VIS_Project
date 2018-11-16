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

@Entity(name="theft_claim")
@GenericGenerator(name="claimid",strategy="com.vims.generators.ClaimIdGenerator")
public class TheftClaim {

	
	@Id
	@GeneratedValue(generator="claimid")
	private String claim_id;
	private String total_amount;
	private Date theft_date;
	private Date complaint_date;
	private String fir_number;
	private String claim_amount;
	private String status;
	private String customer_id;
	private String policy_id;
	
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}

	//private String customer_id;
	
	//private VehicleRegistration vehicle;

	public String getClaim_id() {
		return claim_id;
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

	public Date getTheft_date() {
		return theft_date;
	}

	public void setTheft_date(Date theft_date) {
		this.theft_date = theft_date;
	}

	public Date getComplaint_date() {
		return complaint_date;
	}

	public void setComplaint_date(Date complaint_date) {
		this.complaint_date = complaint_date;
	}

	public String getFir_number() {
		return fir_number;
	}

	public void setFir_number(String fir_number) {
		this.fir_number = fir_number;
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

	


	
	
	
	
	public TheftClaim(String claim_id, String total_amount, Date theft_date, Date complaint_date, String fir_number,
			String claim_amount, String status, Customer cust, VehicleRegistration vehicle) {
		super();
		this.claim_id = claim_id;
		this.total_amount = total_amount;
		this.theft_date = theft_date;
		this.complaint_date = complaint_date;
		this.fir_number = fir_number;
		this.claim_amount = claim_amount;
		this.status = status;
		//this.cust = cust;
		//this.vehicle = vehicle;
	}

	public TheftClaim() {
	
	}
	
	
	
	
	
}
