package com.nit.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	private Date dob;
	private String gender;
	private Integer countryNumber;
	private Integer stateNumber;
	private Integer cityNumber;
	private String password;
	private String accountStatus;
	private Date createdDate;
	private Date updatedDate;
}
