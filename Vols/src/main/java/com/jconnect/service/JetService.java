package com.jconnect.service;

import java.util.ArrayList;
import java.util.List;

import com.jconnect.entities.Jet;


public interface JetService {
	public List<Jet> findAll();
    public void delete(Long id);
    public Jet save(Jet jet);
    public Jet editJet(Jet jet);
    public Jet findById(Long id);
    public ArrayList<Jet> searchJet(String value);
	public List<Jet> findByName(String name);
    public List<Jet> search(String Name);
    public List<Jet> findDispoJets();
    
}
