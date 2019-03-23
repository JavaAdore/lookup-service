package com.eltaieb.microservice.lookupservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eltaieb.microservice.lookupservice.dao.JpaProductLocaleDao;
import com.eltaieb.microservice.lookupservice.dao.JpaResourceBundleDao;
import com.eltaieb.microservice.lookupservice.entity.ProductLocaleEntity;
import com.eltaieb.microservice.lookupservice.entity.ResourceBundleEntity;
import com.eltaieb.microservice.lookupservice.service.api.ResourceBundleService;
import com.eltaieb.microservice.lookupservice.service.model.ResourceBundleEntry;

@Service
public class ResourceBundleServiceBean implements ResourceBundleService {

	private JpaResourceBundleDao jpaResourceBundleDao;
	private JpaProductLocaleDao productLocaleDao;

	public ResourceBundleServiceBean(JpaResourceBundleDao jpaResourceBundleDao, JpaProductLocaleDao productLocaleDao) {
		this.jpaResourceBundleDao = jpaResourceBundleDao;
		this.productLocaleDao = productLocaleDao;
	}

	@Override
	public void save(ResourceBundleEntry resourceBundleEntry) {
		ResourceBundleEntity resourceBundleEntity = toResourceBundleEntity(resourceBundleEntry);
		jpaResourceBundleDao.save(resourceBundleEntity);
	}

	private ResourceBundleEntity toResourceBundleEntity(ResourceBundleEntry resourceBundleEntry) {
		ProductLocaleEntity productLocaleEntity = 	productLocaleDao.findByCode(resourceBundleEntry.getLocaleCode());
		
		ResourceBundleEntity resourceBundleEntity = new ResourceBundleEntity();
		resourceBundleEntity.setKey(resourceBundleEntry.getKey());
		resourceBundleEntity.setValue(resourceBundleEntry.getValue());
		resourceBundleEntity.setLocale(productLocaleEntity);
		return resourceBundleEntity;
	}

	@Override
	public List<ResourceBundleEntity> getResourceBundle(String prefex, String localeCode) {
		return jpaResourceBundleDao.getResourceBundle( prefex,  localeCode) ;
	}

	@Override
	public List<ResourceBundleEntity> getResourceBundle(String key) {
		 return jpaResourceBundleDao.getResourceBundle( key);
	}

}
