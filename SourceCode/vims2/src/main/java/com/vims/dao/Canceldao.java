package com.vims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vims.model.Cancellation;

public interface Canceldao extends JpaRepository<Cancellation, String>{

	@Query("from cancellation_details cd where cd.cancel_id like %:cancel_id%")
	List<Cancellation> findByCancelId(@Param("cancel_id") String cancel_id);
	
}
