package com.eltaieb.microservice.lookupservice.entity;

import java.io.Serializable;

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

@Data
@Entity(name="LocationEntity")
@Table(name="location")
public class LocationEntity implements Serializable{
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="location_pk_seq")
	@SequenceGenerator(name="location_pk_seq" , sequenceName="location_pk_seq", allocationSize=1)
	private Long id;
	
	private String nameKey;
	
	@ManyToOne
	@JoinColumn(name="parent_location_id" , referencedColumnName="id")
	private LocationEntity parentLocation;
	
	
	@Column(name="is_active")
	private Boolean active;
	
}
