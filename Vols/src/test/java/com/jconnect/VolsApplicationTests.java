package com.jconnect;


import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jconnect.api.controller.UserApiController;
import com.jconnect.dao.JetRepository;
import com.jconnect.service.JetService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class VolsApplicationTests {
	
	@Mock
	JetService jetService;
	
	@Mock
	JetRepository jetRepository;

	/*@Test
	public void findAllJets() {
	//	List<Jet> jets=jetService.findAllJet();
	//	assertThat(jets.size()).isEqualTo(3);
		
	}
	*/
	
	private MockMvc mocMvc;
	
	@InjectMocks
	UserApiController apiController;
	
	@Before
public void setup() {
		MockitoAnnotations.initMocks(this);
		mocMvc=MockMvcBuilders.standaloneSetup(apiController).build();
	}
	
	
	@Test
	public void jetVerif() throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/api/jets"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void findById() throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/api/jet/{id}", 15L))
		.andExpect(MockMvcResultMatchers.jsonPath("$.name", is("jet1")));
	}


}
