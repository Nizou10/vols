package com.jconnect.dto;

import java.io.Serializable;

public class ReservationDto implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5413240949169101589L;
	private Long idUser;
	private Long idJet;
	private Long idPilote;
	private String typeReservation;
	private Long idVol;
	private Long idCancelCause;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdJet() {
		return idJet;
	}
	public void setIdJet(Long idJet) {
		this.idJet = idJet;
	}
	public Long getIdPilote() {
		return idPilote;
	}
	public void setIdPilote(Long idPilote) {
		this.idPilote = idPilote;
	}
	public String getTypeReservation() {
		return typeReservation;
	}
	public void setTypeReservation(String typeReservation) {
		this.typeReservation = typeReservation;
	}
	public Long getIdVol() {
		return idVol;
	}
	public void setIdVol(Long idVol) {
		this.idVol = idVol;
	}
	public Long getIdCancelCause() {
		return idCancelCause;
	}
	public void setIdCancelCause(Long idCancelCause) {
		this.idCancelCause = idCancelCause;
	}
	
	

}
