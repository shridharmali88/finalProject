package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "STATE_MASTER")
public class StateEntity{
	@Id
	@Column(name = "STATE_ID",length = 10)
	@Type(type = "int")
	private Integer stateId;
	
	@Column(name = "STATE_NAME",length = 35)
	@Type(type = "string")
	private String stateName;;
	
	@Column(name = "COUNTRY_ID",length = 10)
	@Type(type = "int")
	private Integer countryId;
}
