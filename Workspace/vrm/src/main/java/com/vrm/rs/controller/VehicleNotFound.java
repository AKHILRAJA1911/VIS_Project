package com.vrm.rs.controller;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleNotFound extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//static final long serialVersionUID = -7514407109669472202L;

	public VehicleNotFound(String searchTerm) {
		super("could not find Vehicle " + searchTerm + "'.");
	}
	

}
