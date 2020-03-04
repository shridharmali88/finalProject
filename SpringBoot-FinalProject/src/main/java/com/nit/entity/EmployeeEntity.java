package com.nit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID",length = 10)
	@Type(type = "int")
	private Integer employeeId;
	
	@Column(name = "FIRST_NAME",length = 35)
	@Type(type = "string")
	private String firstName;
	
	@Column(name = "LAST_NAME",length = 35)
	@Type(type = "string")
	private String lastName;

	@Column(name = "EMAIL",length = 35,unique = true,nullable = false)
	@Type(type = "string")
	private String email;
	
	@Column(name = "PHONE_NUMBER",length = 10)
	@Type(type = "long")
	private Long phoneNumber;
	
	@Column(name = "DOB")
	@Type(type = "java.util.Date")
	private Date dob;

	@Column(name = "GENDER",length = 5)
	@Type(type = "string")
	private String gender;
	
	@Column(name = "COUNTRY_NUMBER",length = 10)
	@Type(type = "int")
	private Integer countryNumber;
	
	@Column(name = "STATE_NUMBER",length = 10)
	@Type(type = "int")
	private Integer stateNumber;
	
	@Column(name = "CITY_NUMBER",length = 10)
	@Type(type = "int")
	private Integer cityNumber;

	@Column(name = "PASSWORD",length = 35)
	@Type(type = "string")
	private String password;

	@Column(name = "ACCOUNT_STATUS",length =10)
	@Type(type = "string")
	private String accountStatus;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE",insertable = false)
	private Date updatedDate;

	
}
