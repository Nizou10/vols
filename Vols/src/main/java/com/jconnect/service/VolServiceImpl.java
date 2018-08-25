package com.jconnect.service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jconnect.dao.VolRepository;
import com.jconnect.entities.Vol;

@Service("volService")
public class VolServiceImpl implements VolService{
	@Autowired
	VolRepository volRepository;

	@Override
	public Vol save(Vol vol) {
		// TODO Auto-generated method stub
		return volRepository.save(vol);
	}

	@Override
	public Optional<Vol> findById(Long id) {
		return volRepository.findById(id);
	}

	@Override
	public Vol update(Vol vol) {
		// TODO Auto-generated method stub
		return volRepository.save(vol);

	}

	@Override
	public void remove(Vol vol) {
		 volRepository.delete(vol);

		
	}

	@Override
	public List<Vol> findAll() {
		return volRepository.findAll();
	}

	@Override
	public List<Vol> search(String villedepart, Date datedepart) {
		return volRepository.search(villedepart, datedepart);
	}

}
