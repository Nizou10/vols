package com.jconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jconnect.dao.ReservationRepository;
import com.jconnect.entities.Reservation;
import com.jconnect.entities.User;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

	   @Autowired
			protected ReservationRepository reservationRepository;
			
	@Override
	public Reservation save(Reservation reservation) {
		
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findById(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(id).get();
	}

	@Override
	public List<Reservation> search(String Name) {
		return reservationRepository.search(Name);
	
	}

	@Override
	public void delete(Long id) {
		
		reservationRepository.delete(findById(id));
	}

	@Override
	public List<Reservation> findByUser(User user) {
		
		return reservationRepository.findByUser(user);
	}

	@Override
	public void delete(Reservation reservation) {
		 reservationRepository.delete(reservation);
		
	}

	@Override
	public List<Reservation> findByState(String state) {
		// TODO Auto-generated method stub
		return reservationRepository.findByState(state);
	}
	
	
	

}
