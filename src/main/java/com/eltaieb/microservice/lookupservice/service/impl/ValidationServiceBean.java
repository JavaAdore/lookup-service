package com.eltaieb.microservice.lookupservice.service.impl;

import org.springframework.stereotype.Service;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.ErrorMessageCode;
import com.eltaieb.microservice.lookupservice.service.api.ValidationService;
import com.eltaieb.microservice.lookupservice.service.model.ResourceBundleEntry;

@Service
public class ValidationServiceBean implements ValidationService {

	@Override
	public void validateChildLocationId(Long parentLocationId) throws ServiceException {
			
		validateLocationIdPresent(parentLocationId);
		validateLocationIdPositiveValue(parentLocationId);
	}

	private void validateLocationIdPositiveValue(Long parentLocationId) throws ServiceException {
		
		if(parentLocationId<0)
		{
			throw new ServiceException(ErrorMessageCode.LOCATION_ID_SHOULD_BE_POSITIVE_VALUE);
	
		}
	}

	private void validateLocationIdPresent(Long parentLocationId) throws ServiceException {
		if(null == parentLocationId)
		{
			throw new ServiceException(ErrorMessageCode.NO_LOCATION_ID_PRESENTED);
		}		
	}

	@Override
	public void validate(ResourceBundleEntry resourceBundleEntry) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateGetResourceBundleMap(String prefex, String localeCode) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

 
	 
 
}
