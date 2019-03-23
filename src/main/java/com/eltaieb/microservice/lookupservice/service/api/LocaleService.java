package com.eltaieb.microservice.lookupservice.service.api;

import java.util.List;

import com.eltaieb.microservice.lookupservice.entity.ProductLocaleEntity;

public interface LocaleService {

	List<ProductLocaleEntity> getAllActiveLocales();

	
}
