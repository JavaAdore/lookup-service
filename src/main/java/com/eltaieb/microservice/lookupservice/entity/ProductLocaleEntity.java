package com.eltaieb.microservice.lookupservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="ProductLocale")
@Table(name="product_locale")
public class ProductLocaleEntity {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="locale_pk_seq")
	@SequenceGenerator(name="locale_pk_seq" , sequenceName="locale_pk_seq",allocationSize=1)
	private Long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="is_active")
	private Boolean active;
}
