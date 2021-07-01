package com.cognizant;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class SpringWsTestingApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService mockService;
	
	@Test
	public void employeeStoreTest() throws Exception {
		User user = new User();
		user.setName("Alex");
		user.setAge(35);
		when(mockService.store(user)).thenReturn(user);
		mvc.perform(post("/api/").content("{\"name\":\"Alex\",\"age\":35}")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void greetingsReturnsOk() throws Exception {
		mvc.perform(get("/api/Charles"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	@Test
	public void greetingsReturnsContent() throws Exception {
		mvc.perform(get("/api/Charles"))
		.andDo(print())
		.andExpect(content().string(containsString("Charles")));
	}
	
	

}
