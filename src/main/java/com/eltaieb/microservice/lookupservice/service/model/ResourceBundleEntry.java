package com.eltaieb.microservice.lookupservice.service.model;

import java.io.Serializable;

import com.eltaieb.microservice.base.footprint.Referenceable;

import lombok.Data;

@Data
public class ResourceBundleEntry implements Serializable , Referenceable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String key;
	
	private String value;
	
	private String localeCode;

	@Override
	public String getReference() {
		return String.format("%s:%s:%s", key,value,localeCode);
	}
	
}
