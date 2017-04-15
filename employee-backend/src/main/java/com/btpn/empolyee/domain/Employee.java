package com.btpn.empolyee.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@NotBlank
	@Column(name = "first_name", length = 25)
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String nationality;
	private String martialStatus;
	private String phone;
	private String email;
	private Date hiredDate;
	private Date suspendDate;
	private String division;
	private String grade;
	private String subDivision;
	private String status;
	
	
}
