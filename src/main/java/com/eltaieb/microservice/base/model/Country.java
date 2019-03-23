package com.eltaieb.microservice.base.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Country {

	
	private Long id;
	
	private String dealCode;
	
	private String code;
	
	private String Alpha3Code;

	private String nameKey;
	
	private boolean defaultCountry;
	
	private boolean active;
	
	private String imageUrl;
	
	
	
	
	
	public Country(String code, String alpha3Code, String nameKey, String imageUrl) {
		super();
		this.code = code;
		Alpha3Code = alpha3Code;
		this.nameKey = nameKey;
		this.imageUrl = imageUrl;
	}





	//temp
	private Map<String,String> nameMap = new HashMap<>();
	
	
	
	public void addName(String locale,String value)
	{
		nameMap.put(locale,value);
	}
	
}
