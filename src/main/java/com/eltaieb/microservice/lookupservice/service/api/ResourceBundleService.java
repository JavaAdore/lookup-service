package com.eltaieb.microservice.lookupservice.service.api;

import java.util.List;

import com.eltaieb.microservice.lookupservice.entity.ResourceBundleEntity;
import com.eltaieb.microservice.lookupservice.service.model.ResourceBundleEntry;

public interface ResourceBundleService {

	void save(ResourceBundleEntry resourceBundleEntry);

	List<ResourceBundleEntity> getResourceBundle(String prefex, String localeCode);

	List<ResourceBundleEntity> getResourceBundle(String key);

}
