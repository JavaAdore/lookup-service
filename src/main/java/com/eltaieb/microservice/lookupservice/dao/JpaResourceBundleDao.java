package com.eltaieb.microservice.lookupservice.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eltaieb.microservice.lookupservice.entity.ProductLocaleEntity;
import com.eltaieb.microservice.lookupservice.entity.ResourceBundleEntity;

public interface JpaResourceBundleDao extends CrudRepository<ResourceBundleEntity,Long>{
	
	public List<ResourceBundleEntity> findByLocale(ProductLocaleEntity locale);

	@Query("select rb from ResourceBundle rb where lower(rb.key) like lower(CONCAT(:prefex,'%')) and lower(rb.locale.code)  = lower(:#{#localeCode}) order by rb.key")
	public List<ResourceBundleEntity> getResourceBundle( @Param("prefex")  String prefex, @Param("localeCode")  String localeCode);
	
	
	@Query("select rb from ResourceBundle rb where lower(rb.key) like lower(CONCAT(:key,'%')) order by rb.locale.code")
	public List<ResourceBundleEntity> getResourceBundle(@Param("key") String key);
	 
}
