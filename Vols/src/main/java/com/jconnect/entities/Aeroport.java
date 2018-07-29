package com.jconnect.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aeroport")
public class Aeroport implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String city_name;
	private String airport_code;
	private String airport_name;
	private String country_name;
	private String country_abreviation;
	private Long world_area_code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getAirport_code() {
		return airport_code;
	}

	public void setAirport_code(String airport_code) {
		this.airport_code = airport_code;
	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCountry_abreviation() {
		return country_abreviation;
	}

	public void setCountry_abreviation(String country_abreviation) {
		this.country_abreviation = country_abreviation;
	}

	public Long getWorld_area_code() {
		return world_area_code;
	}

	public void setWorld_area_code(Long world_area_code) {
		this.world_area_code = world_area_code;
	}

}
