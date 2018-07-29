package com.jconnect;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jconnect.entities.Jet;
import com.jconnect.service.JetService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {
	
	@Autowired
	JetService jetService;
	

	@Test
	public void findAllJets() {
		List<Jet> jets=jetService.findAll();
		assertThat(jets.size()).isEqualTo(4);
		assertTrue(jets.get(0).getNbPlace() == 150);

		
	}
	
	@Test
	@Transactional
	public void saveJet() {
		Jet jet=new Jet();
		jet.setDescription("jet45");
		jet.setDisponible(true);
		jet.setName("newJet");
		jet.setNbPlace(300L);
		jetService.save(jet);
		
		
	}

}
