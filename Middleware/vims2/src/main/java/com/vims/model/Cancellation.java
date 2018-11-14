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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer cust;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="policy_id")
	private VehicleRegistration vehicle;

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

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public VehicleRegistration getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleRegistration vehicle) {
		this.vehicle = vehicle;
	}

	
	
	
	
	public Cancellation(String cancel_id, String total_amount, String withdraw_amount, Date last_paid_date,
			Date cancel_date, Date registered_date, Customer cust, VehicleRegistration vehicle) {
		super();
		this.cancel_id = cancel_id;
		this.total_amount = total_amount;
		this.withdraw_amount = withdraw_amount;
		this.last_paid_date = last_paid_date;
		this.cancel_date = cancel_date;
		this.registered_date = registered_date;
		this.cust = cust;
		this.vehicle = vehicle;
	}

	public Cancellation() {

	}

}
