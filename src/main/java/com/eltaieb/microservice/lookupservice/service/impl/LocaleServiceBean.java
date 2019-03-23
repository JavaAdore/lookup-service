package com.eltaieb.microservice.lookupservice.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.eltaieb.microservice.lookupservice.dao.JpaProductLocaleDao;
import com.eltaieb.microservice.lookupservice.entity.ProductLocaleEntity;
import com.eltaieb.microservice.lookupservice.service.api.LocaleService;

@Service
public class LocaleServiceBean implements LocaleService {

	private static final Logger log = Logger.getLogger(LocaleServiceBean.class.getName());

	 private JpaProductLocaleDao jpaLocaleDao;
	 
	 public LocaleServiceBean(JpaProductLocaleDao jpaLocaleDao)
	 {
		 this.jpaLocaleDao=jpaLocaleDao;
	 }

	@Override
	public List<ProductLocaleEntity> getAllActiveLocales() {
		return jpaLocaleDao.findAllActiveLocales();
	}

	 

}
