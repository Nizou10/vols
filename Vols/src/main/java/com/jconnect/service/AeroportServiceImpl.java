package com.jconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jconnect.dao.AeroportRepository;
import com.jconnect.entities.Aeroport;

@Service("aeroportService")
public class AeroportServiceImpl implements AeroportService{
	
	@Autowired
	protected AeroportRepository aeroportRep;

	@Override
	public List<Aeroport> search(String name) {
		
		
		return aeroportRep.search(name);
	}

}
