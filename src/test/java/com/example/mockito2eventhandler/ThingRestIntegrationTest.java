package com.example.mockito2eventhandler;

import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import lombok.SneakyThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ThingRestIntegrationTest {

	@SpyBean
	private ThingRepositoryEventHandler eventHandler;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@SneakyThrows
	public void should_invoke_handler_once() {
		mockMvc.perform(post("/things")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"some\"}"))
				.andDo(print())
				.andExpect(status().isCreated())
		;

		then(eventHandler).should().doAfterCreate(any());
	}

}
