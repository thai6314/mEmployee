package com.vmo.qlfresher.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
public class Fresher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fullname")
	private String fullname;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Invalid phone number entered")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "programing_language")
	private String programingLanguage;

	@ManyToOne
	@JoinColumn(name = "center_id")
	private Center center;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public Fresher() {
	}

	public Fresher(int id, String fullname, String email, String phoneNumber, String address, String programingLanguage,
			Center center, Company company) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.programingLanguage = programingLanguage;
		this.center = center;
		this.company = company;
	}

	public Fresher(String fullname, String email, String phoneNumber, String address, String programingLanguage,
			Center center, Company company) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.programingLanguage = programingLanguage;
		this.center = center;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProgramingLanguage() {
		return programingLanguage;
	}

	public void setProgramingLanguage(String programingLanguage) {
		this.programingLanguage = programingLanguage;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
