package com.btpn.empolyee.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@NotBlank
	@Column(name = "first_name", length = 25, nullable = false)
	private String firstName;
	
	@NotBlank
	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;
	
	@NotBlank
	@Column(length = 6, nullable = false)
	private String gender;
	
	@NotBlank
	@Column(name = "date_of_birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@NotBlank
	@Column(length = 25, nullable = true)
	private String nationality;
	
	@Column(name = "martial_status", length = 7, nullable = true)
	private String martialStatus;
	
	@Column(length = 15, nullable = true)
	private String phone;
	
	@Email
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	
	@Column(name = "hired_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date hiredDate;
	
	@Column(name = "suspend_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date suspendDate;
	
	@Column(nullable = true)
	private String division;
	
	@Column(nullable = true)
	private String grade;
	
	@Column(name = "sub_division", nullable = true)
	private String subDivision;
	
	@Column(nullable = true)
	private String status;
	
	@Column(nullable = true)
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "id_city", nullable = false)
	private City city;
	
}
