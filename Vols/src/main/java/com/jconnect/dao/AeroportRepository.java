package com.jconnect.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jconnect.entities.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport,Long> {
	
	@Query("SELECT a FROM Aeroport a WHERE a.city_name like %:value% or a.airport_name like %:value%")
	  public List<Aeroport> search(@Param("value") String value);
	

}
