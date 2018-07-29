package com.jconnect.service;

import java.util.List;

import com.jconnect.entities.CancelCause;

public interface CancelCauseService {
	public CancelCause findById(Long id);
	public List<CancelCause> findAll();

}
