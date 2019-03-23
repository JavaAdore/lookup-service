package com.eltaieb.microservice.lookupservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="ResourceBundle")
@Table(name="resource_bundle")
public class ResourceBundleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="resource_bundle_pk_seq")
	@SequenceGenerator(name="resource_bundle_pk_seq" , sequenceName="resource_bundle_pk_seq",allocationSize=1)
	private Long id;
	
	@Column(name="key")
	private String key;
	
	@Column(name="value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name="product_locale_id" , referencedColumnName="id")
	private ProductLocaleEntity locale;
	
}