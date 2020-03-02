package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "CITY_MASTER")
public class CityEntity{
	@Id
	@Column(name = "CITY_ID",length = 10)
	@Type(type = "int")
	private Integer cityId;

	@Column(name = "CITY_NAME",length = 35)
	@Type(type = "string")
	private String cityName;

	@Column(name = "STATE_ID",length = 10)
	@Type(type = "int")
	private Integer stateId;
}
