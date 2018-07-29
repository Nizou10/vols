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

import com.jconnect.entities.Pilote;
import com.jconnect.service.PiloteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceLayer {
	
	
	@Autowired
	PiloteService piloteService;
	
	@Test
	public void testAddPilote() {
		Pilote pilote = new Pilote();
		pilote.setFirstName("Pilote 7");
		pilote.setDisponible(true);
		pilote.setEmail("ben@pilote.com");
		pilote.setLastName("ben pilote7");
		pilote.setTel(12345L);		
		piloteService.addPilote(pilote);
		
		List<Pilote> found = piloteService.findByLastName("ben pilote7");
		System.out.println(found.size());
		//assertTrue(found.size() == 3);
		assertThat(found.get(0).getFirstName()).isEqualTo("Pilote 7");
	}

}
