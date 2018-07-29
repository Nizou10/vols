package com.jconnect.service;

import java.util.List;

import com.jconnect.entities.TypeJet;

public interface TypeJetService {
	public TypeJet findByName(String Name);
	public TypeJet findById(Long id);
	public List<TypeJet> findAll();
	public TypeJet save(TypeJet typejet);

}
