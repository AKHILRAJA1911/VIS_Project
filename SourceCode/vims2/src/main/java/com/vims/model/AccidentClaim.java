package com.vims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	
	private String policy_id;
	private String customer_id;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
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
	
	public String getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}
	
	
	
	
	
}
