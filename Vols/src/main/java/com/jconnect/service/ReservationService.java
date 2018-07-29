package com.jconnect.service;

import java.util.List;

import com.jconnect.entities.Jet;
import com.jconnect.entities.Reservation;
import com.jconnect.entities.User;

public interface ReservationService {
	public Reservation save(Reservation reservation);

	public List<Reservation> findAll();

	public Reservation findById(Long id);

	public List<Reservation> search(String Name);

	public void delete(Long id);
	
	public void delete(Reservation reservation);

	public List<Reservation> findByUser(User user);
	
	public List<Reservation> findByState( String state);
}
