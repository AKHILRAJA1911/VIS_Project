package com.vims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.dao.Canceldao;
import com.vims.model.Cancellation;
@Service
public class CancellationServiceImpl implements CancellationService{

	@Autowired
	private Canceldao dao;
	@Override
	public List<Cancellation> findByCancelId(String cancel_id) {
		// TODO Auto-generated method stub
		return dao.findByCancelId(cancel_id);
	}

	@Override
	public List<Cancellation> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

	@Override
	public void deleteById(String cancel_id) {
		// TODO Auto-generated method stub
		dao.deleteById(cancel_id);
	}

	@Override
	public Cancellation save(Cancellation c) {
		// TODO Auto-generated method stub
		return dao.save(c);
	}

	@Override
	public Optional<Cancellation> findById(String cancelid) {
		// TODO Auto-generated method stub
		return dao.findById(cancelid);
	}

}
