package com.eltaieb.microservice.lookupservice.service.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationModel implements Serializable {
	
	public LocationModel(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
 
}
