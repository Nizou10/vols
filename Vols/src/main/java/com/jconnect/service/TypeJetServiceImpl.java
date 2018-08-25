package com.jconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jconnect.dao.jetTypeRepository;
import com.jconnect.entities.TypeJet;
@Service("typejetservice")
public class TypeJetServiceImpl implements TypeJetService {

	 @Autowired
		protected jetTypeRepository jetTypeRepository;
		 
	@Override
	public TypeJet findByName(String Name) {
		// TODO Auto-generated method stub
		return jetTypeRepository.findByName(Name);
	}

	@Override
	public TypeJet findById(Long id) {
		return jetTypeRepository.findById(id).get();
	}

	@Override
	public List<TypeJet> findAll() {
		// TODO Auto-generated method stub
		return jetTypeRepository.findAll();
	}

	@Override
	public TypeJet save(TypeJet typejet) {
		// TODO Auto-generated method stub
		return jetTypeRepository.save(typejet);
	}

}
