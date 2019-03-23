package com.eltaieb.microservice.base.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Locale {
 
	
	
	private String code;
	
	private String name;

	public Locale(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	
	
	 
}
