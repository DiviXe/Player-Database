package com.game.PlayerDatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class PlayerDatabaseRestTests {

	@Autowired
	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;
	
	@BeforeEach 
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/players"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		mockMvc.perform(get("/servers"))
        	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		mockMvc.perform(get("/servercomputers"))
        	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
	}
	@Test
	public void apiStatusOkPlayers() throws Exception {
		mockMvc.perform(get("/api/players")).andExpect(status().isOk());
		mockMvc.perform(get("/api/servers")).andExpect(status().isOk());

	}

	//servercomputers mockMvc not working?
	
}
