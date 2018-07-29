package com.jconnect.service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jconnect.entities.Vol;



public interface VolService {
	public Vol save(Vol vol);
	public Optional<Vol> findById(Long id);
	public Vol update(Vol vol);
	public void remove(Vol vol);
	public List<Vol> findAll();
	public List<Vol>search(String villedepart,Date datedepart);

}
