package com.eltaieb.microservice.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eltaieb.microservice.base.model.Locale;
import com.eltaieb.microservice.base.model.ServiceResponse;
import com.eltaieb.microservice.base.model.SuccessServiceResponse;
import com.eltaieb.microservice.lookupservice.facade.LookupServiceFacade;

@RestController
@RequestMapping("locale")
public class LocaleController {

	
	
	private LookupServiceFacade lookupServiceFacade;

	public LocaleController(LookupServiceFacade lookupServiceFacade)
	{
		this.lookupServiceFacade=lookupServiceFacade;
	}
	
	@RequestMapping(path="activeLocales", method=RequestMethod.GET)
	public ServiceResponse<List<Locale>> getAllActiveLocales()
	{
		List<Locale> activeLocales = lookupServiceFacade.getAllActiveLocales();
		return new SuccessServiceResponse<List<Locale>>(activeLocales);
	}
	
   
}
