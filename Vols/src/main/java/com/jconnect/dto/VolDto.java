package com.jconnect.dto;

import java.io.Serializable;

public class VolDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -322980307081675023L;
	private Long id;
	private String dateDepart;
	private String dateRetour;
	private int nbPassager;
	private String villeDepart;
	private String villeArrivee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}
	public int getNbPassager() {
		return nbPassager;
	}
	public void setNbPassager(int nbPassager) {
		this.nbPassager = nbPassager;
	}
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

}
