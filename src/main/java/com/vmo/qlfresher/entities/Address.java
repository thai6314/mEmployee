package com.vmo.qlfresher.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "no_home")
	private String noHome;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@OneToOne
	@JoinColumn(name = "address")
	private Center center;

	public Address(String noHome, String street, String district, String city, String country) {
		super();
		this.noHome = noHome;
		this.street = street;
		this.district = district;
		this.city = city;
		this.country = country;
	}
	
	public Address(int id, String noHome, String street, String district, String city, String country, Center center) {
		super();
		this.id = id;
		this.noHome = noHome;
		this.street = street;
		this.district = district;
		this.city = city;
		this.country = country;
		this.center = center;
	}

	public Address() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoHome() {
		return noHome;
	}

	public void setNoHome(String noHome) {
		this.noHome = noHome;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	
	
}
