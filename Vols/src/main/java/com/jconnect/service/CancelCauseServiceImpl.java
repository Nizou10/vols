package com.jconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jconnect.dao.CauseRepository;
import com.jconnect.entities.CancelCause;
@Service("cancelCauseService")
public class CancelCauseServiceImpl implements CancelCauseService{
	
	@Autowired
	protected CauseRepository causeRepository;

	@Override
	public CancelCause findById(Long id) {
		// TODO Auto-generated method stub
		return causeRepository.findById(id).get();
	}

	@Override
	public List<CancelCause> findAll() {
		// TODO Auto-generated method stub
		return causeRepository.findAll();
	}

}
