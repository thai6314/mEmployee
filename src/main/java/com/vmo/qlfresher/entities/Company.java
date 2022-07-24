package com.vmo.qlfresher.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Name shouldn't be null")
	@Column(name="name")
	private String name;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Invalid phone number entered")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="description")
	private String description;
	
	
//	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum eight characters, at least one letter and one number")
	@Column(name = "password")
	private String password;
	
//	@OneToMany(mappedBy = "company")
//	private List<Center> centers;
	
	public Company() {}

	public Company(String name,String email,String phoneNumber, String description) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}
	
	public Company(int id, String name,String email,String phoneNumber, String description, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.password = password;
	
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//
//	public List<Center> getCenters() {
//		return centers;
//	}
//
//	public void setCenters(List<Center> centers) {
//		this.centers = centers;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
