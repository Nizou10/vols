package com.jconnect.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jconnect.entities.CancelCause;

public interface CauseRepository  extends JpaRepository<CancelCause, Long>{
	public Optional<CancelCause> findById(Long id);
	public List <CancelCause> findAll();
}
