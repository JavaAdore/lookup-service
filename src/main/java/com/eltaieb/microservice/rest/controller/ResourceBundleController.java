package com.eltaieb.microservice.rest.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.ServiceResponse;
import com.eltaieb.microservice.base.model.SuccessServiceResponse;
import com.eltaieb.microservice.lookupservice.facade.LookupServiceFacade;
import com.eltaieb.microservice.lookupservice.service.model.ResourceBundleEntry;
 
@RestController
@RequestMapping("resourceBundle")
 public class ResourceBundleController {
	
	private LookupServiceFacade lookupServiceFacade;
	
	public ResourceBundleController(LookupServiceFacade lookupServiceFacade)
	{
		this.lookupServiceFacade=lookupServiceFacade;
	}
   
	 
  	@RequestMapping(path ="/" , method=RequestMethod.POST)
 	public ServiceResponse<Object> save(@RequestBody ResourceBundleEntry  resourceBundleEntry) throws ServiceException
	{
 		lookupServiceFacade.saveResourceBundleEntry(resourceBundleEntry);
 		return new SuccessServiceResponse<Object>(null);
	}
	
 	
 	@RequestMapping(path ="/resourceBundleMap" , method=RequestMethod.GET)
	public ServiceResponse<Map<String,String>> getResourceBundleMap( @RequestParam("prefex") String prefex ,@RequestParam("localeCode") String localeCode) throws ServiceException
	{
		Map<String,String> resourceBundleMap = lookupServiceFacade.getResourceBundleMap( prefex ,  localeCode);
		return new SuccessServiceResponse<Map<String,String>> (resourceBundleMap);
	}

 	
	@RequestMapping(path ="/resourceBundleMap/{key}" , method=RequestMethod.GET)
	public  SuccessServiceResponse<Map<String,String>> getResourceBundleMap( @PathVariable("key") String key)
	{
		Map<String,String> resourceBundleMap = lookupServiceFacade.getResourceBundleMap(key);
		return new SuccessServiceResponse<Map<String,String>> (resourceBundleMap);

	}

	 

	
	
	
	 
}