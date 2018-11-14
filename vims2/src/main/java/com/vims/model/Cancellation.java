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

@Entity(name="cancellation_details")
@GenericGenerator(name="cancelid",strategy="com.vims.generators.CancelIdGenerator")
public class Cancellation {
	

	@Id
	@GeneratedValue(generator="cancelid")
	private String cancel_id;
	private String total_amount;
	private String withdraw_amount;
	private Date last_paid_date;
	private Date cancel_date;
	private Date registered_date;
	private String status;

	private String customer_id;
	private String policy_id;
	public String getCancel_id() {
		return cancel_id;
	}
	public void setCancel_id(String cancel_id) {
		this.cancel_id = cancel_id;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getWithdraw_amount() {
		return withdraw_amount;
	}
	public void setWithdraw_amount(String withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}
	public Date getLast_paid_date() {
		return last_paid_date;
	}
	public void setLast_paid_date(Date last_paid_date) {
		this.last_paid_date = last_paid_date;
	}
	public Date getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}
	public Date getRegistered_date() {
		return registered_date;
	}
	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
}
