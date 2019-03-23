package com.eltaieb.microservice.lookupservice.facade;

import java.util.List;
import java.util.Map;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.Locale;
import com.eltaieb.microservice.lookupservice.service.model.LocationModel;
import com.eltaieb.microservice.lookupservice.service.model.ResourceBundleEntry;

public interface LookupServiceFacade {


	void saveResourceBundleEntry(ResourceBundleEntry resourceBundleEntry) throws ServiceException;

	Map<String, String> getResourceBundleMap(String prefex, String localeCode) throws ServiceException;

	List<Locale> getAllActiveLocales();

	Map<String, String> getResourceBundleMap(String key);

 
 
}
