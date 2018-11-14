package com.vims.service;

import java.util.List;
import java.util.Optional;

import com.vims.model.Cancellation;

public interface CancellationService {

	public List<Cancellation> findByCancelId(String cancelid);
	public List<Cancellation> findAll();
	public  Optional<Cancellation> findById(String cancelid);
	void deleteById(String cancelid);
	public Cancellation save(Cancellation c);
}
