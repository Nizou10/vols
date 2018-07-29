package com.jconnect.service;

import java.util.ArrayList;
import java.util.List;

import com.jconnect.entities.Jet;


public interface JetService {
	public List<Jet> findAll();
    public void deleteJet(Long id);
    public Jet addJet(Jet jet);
    public Jet editJet(Jet jet);
    public Jet findJetById(Long id);
    public ArrayList<Jet> searchJet(String value);
	public List<Jet> findByName(String name);
    public List<Jet> search(String Name);
    public List<Jet> findDispoJets();
    
}
