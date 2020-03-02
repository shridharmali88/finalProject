package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COUNTRY_MASTER")
public class CountryEntity{
	@Id
	@Column(name = "COUNTRY_ID",length = 10)
	@Type(type = "int")
	private Integer countryId;

	@Column(name = "COUNTRY_NAME",length = 35)
	@Type(type = "string")
	private String countryName;;
}
