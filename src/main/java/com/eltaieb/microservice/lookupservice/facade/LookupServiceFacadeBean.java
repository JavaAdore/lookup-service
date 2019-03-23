package com.eltaieb.microservice.lookupservice.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.Locale;
import com.eltaieb.microservice.lookupservice.entity.ProductLocaleEntity;
import com.eltaieb.microservice.lookupservice.entity.ResourceBundleEntity;
import com.eltaieb.microservice.lookupservice.service.api.LocaleService;
import com.eltaieb.microservice.lookupservice.service.api.ResourceBundleService;
import com.eltaieb.microservice.lookupservice.service.api.ValidationService;
import com.eltaieb.microservice.lookupservice.service.model.LocationModel;
import com.eltaieb.microservice.lookupservice.service.model.ResourceBundleEntry;
  
@Service
public class LookupServiceFacadeBean implements LookupServiceFacade {

  	private ValidationService validationService;
	private ResourceBundleService resourceBundleService;
	private LocaleService localeService;
	
	public LookupServiceFacadeBean( 
			ValidationService validationService,
			ResourceBundleService resourceBundleService,
			LocaleService localeService) {
			 
		super();
  		this.validationService = validationService;
  		this.resourceBundleService=resourceBundleService;
  		this.localeService=localeService;

 	}

 

	 
	@Override
	public void saveResourceBundleEntry(ResourceBundleEntry resourceBundleEntry) throws ServiceException {
		validationService.validate(resourceBundleEntry);
		resourceBundleService.save(resourceBundleEntry);
	}

	@Override
	public Map<String, String> getResourceBundleMap(String prefex, String localeCode) throws ServiceException {
		validationService.validateGetResourceBundleMap( prefex,  localeCode);
		List<ResourceBundleEntity> resourceBundleEntities = resourceBundleService.getResourceBundle(prefex,localeCode);
		Map<String,String> resourceBundleMap = new HashMap<>();
		resourceBundleEntities.forEach(rb ->{
			resourceBundleMap.put(rb.getKey(), rb.getValue());
		});
		return resourceBundleMap;
	}

	@Override
	public List<Locale> getAllActiveLocales() {
		List<ProductLocaleEntity> localeEntities = localeService.getAllActiveLocales();
		return localeEntities.stream().map(  localeEntity -> 
			  new Locale( localeEntity.getCode(),  localeEntity.getName())
		 ).collect(Collectors.toList());
	}

	@Override
	public Map<String, String> getResourceBundleMap(String key) {
		List<ResourceBundleEntity> resourceBundleEntities = resourceBundleService.getResourceBundle(key);
		
		Map<String,String> resourceBundleMap = new HashMap<>();
		resourceBundleEntities.forEach(rb ->{
			resourceBundleMap.put(rb.getLocale().getCode(), rb.getValue());
		});
		return resourceBundleMap;
		
 	}

	 
	 

	 

	 

}
