package com.jconnect.dto;


import java.io.Serializable;

public class JetDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1576559940049205317L;

	private  Long id;
	private String name;
	private Long idTypeJet;
	
	private Long nbPlace;
	private boolean disponible;
	private String description;
	private String imgUrl;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getIdTypeJet() {
		return idTypeJet;
	}
	public void setIdTypeJet(Long idTypeJet) {
		this.idTypeJet = idTypeJet;
	}
	public Long getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(Long nbPlace) {
		this.nbPlace = nbPlace;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
