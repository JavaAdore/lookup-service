package com.eltaieb.microservice.lookupservice.service.api;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.lookupservice.service.model.ResourceBundleEntry;

public interface ValidationService {

	void validateChildLocationId(Long parentLocationId) throws ServiceException;

	void validate(ResourceBundleEntry resourceBundleEntry) throws ServiceException ;

	void validateGetResourceBundleMap(String prefex, String localeCode)throws ServiceException ;

 
	 
	 
}
