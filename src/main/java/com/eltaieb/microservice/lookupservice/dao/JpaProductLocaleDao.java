package com.eltaieb.microservice.lookupservice.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eltaieb.microservice.lookupservice.entity.ProductLocaleEntity;

public interface JpaProductLocaleDao extends CrudRepository<ProductLocaleEntity,Long>{
 
	@Query("select pl from ProductLocale pl  ") 
	public List<ProductLocaleEntity> findAllActiveLocales();
	
	
	@Query("select pl from ProductLocale pl where upper(pl.code) = upper(:#{#code})   ") 
	public ProductLocaleEntity findByCode(@Param("code") String localeCode); 
	
	
	
	
}
