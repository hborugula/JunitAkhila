package com.ashokit.rest;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashokit.bindings.Book;
import com.ashokit.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = BookRestController.class)
public class BookRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	@InjectMocks
	private BookService bookService;

	@Test
	public void test_1_addBook() throws Exception {
	
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);

		Book b = new Book(101, "Spring", 450.00);
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(b);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/addbook")
																		 .contentType("application/json")
																		 .content(bookJson);

		MvcResult mvcResult = mockMvc.perform(reqBuilder).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201,status);
		
	}
	
	@Test
	public void test_2_addBook() throws Exception {
		
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(false);
		
		Book b = new Book(101, "Spring", 450.00);
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(b);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/addbook")
																		 .contentType("application/json")
																		 .content(bookJson);

		MvcResult mvcResult = mockMvc.perform(reqBuilder).andReturn();

		int status = mvcResult.getResponse().getStatus();

		assertEquals(400, status);
	}

}
