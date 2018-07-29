package com.jconnect.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jconnect.entities.Reservation;
import com.jconnect.entities.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("SELECT r FROM Reservation r WHERE r.user.lastName like %:value% or r.user.firstName like %:value%")
	public List<Reservation> search(@Param("value") String value);
	
	public List<Reservation> findByUser( User user);
	
	public List<Reservation> findByState( String state);
}
