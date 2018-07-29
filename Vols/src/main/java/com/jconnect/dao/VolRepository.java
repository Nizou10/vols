package com.jconnect.dao;




import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jconnect.entities.Vol;



public interface VolRepository extends JpaRepository<Vol, Long> {
	
	
	@Query("select v from Vol v where v.villeDepart like %:value% and v.dateDepart = :datedep")
	public List<Vol> search(@Param("value") String value, @Param("datedep") Date datedep );

}
