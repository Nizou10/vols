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
public class VolsApplicationTests {
	

	private MockMvc mockMvc;
	
	@InjectMocks
	UserApiController api;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(api).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/test"))
		.andExpect(MockMvcResultMatchers.content().string("Test is OK"));
		
	}
	
	

}
