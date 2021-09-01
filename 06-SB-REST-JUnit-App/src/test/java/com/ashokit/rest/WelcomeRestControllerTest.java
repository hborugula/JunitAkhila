package com.ashokit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashokit.service.WelcomeService;

@WebMvcTest(value = WelcomeRestController.class)
public class WelcomeRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WelcomeService welcomeService;

	@Test
	public void test_welcomeMsg() throws Exception {

		when(welcomeService.getWelcomeMsg()).thenReturn("this is test msg");

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/welcome");
		MvcResult mvcResult = mockMvc.perform(reqBuilder).andReturn();

		// String responseStr = mvcResult.getResponse().getContentAsString();

		int status = mvcResult.getResponse().getStatus();

		assertEquals(200, status);

	}
}
