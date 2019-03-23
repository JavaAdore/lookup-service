package com.eltaieb.microservice.lookupservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="CountryEntity")
@Table(name="country")
public class CountryEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="country_pk_seq")
	@SequenceGenerator(name="country_pk_seq" , sequenceName="country_pk_seq", allocationSize=1)
	private Long id;
	
	@Column(name="dial_code")
	private String dialCode;
	
	@Column(name="code")
	private String code;
	
	@Column(name="alpha_3_code")
	private String Alpha3Code;
	
	@Column(name="name_key")
	private String nameKey;
	
	@Column(name="is_default_country")
	private Boolean defaultCountry;
	
	@Column(name="is_active")
	private Boolean active;
	
	@Column(name="flag_image_url")
	private String flagImageUrl;
	
	
	
	
	 
	
}
