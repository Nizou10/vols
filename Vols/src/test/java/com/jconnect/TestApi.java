package com.jconnect;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jconnect.api.controller.UserApiController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApi {
	
	
	private MockMvc mocMvc;
	
	@InjectMocks
	UserApiController apiController;
	
	@Before
public void setup() {
		mocMvc=MockMvcBuilders.standaloneSetup(apiController).build();
	}
	
	
	@Test
	public void jetVerif() throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/api/jets"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		//.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}


	


}
