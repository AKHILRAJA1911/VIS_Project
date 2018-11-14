package com.vims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vims.model.DirectPay;
import com.vims.model.RegisteredPay;

public interface RegisteredPaydao extends JpaRepository<RegisteredPay, String>{

	@Query("from registered_pay rp where rp.payment_id like %:payment_id%")
	List<RegisteredPay> findByPaymentId(@Param("payment_id") String payment_id);
}
