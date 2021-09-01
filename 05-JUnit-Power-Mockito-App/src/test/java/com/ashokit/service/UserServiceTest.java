package com.ashokit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.ashokit.dao.UserDao;

public class UserServiceTest {

	@Test
	public void testGetNameByUserId() {
		UserDao mockDao = PowerMockito.mock(UserDao.class);
		PowerMockito.when(mockDao.findNameById(101)).thenReturn("Nick");
		PowerMockito.when(mockDao.findNameById(102)).thenReturn("Smith");

		UserService service = new UserService(mockDao);
		String name = service.getNameByUserId(101);
		assertEquals("Nick", name);
	}

	@Test
	public void testGetEmailByUserId() {
		UserDao mockDao = PowerMockito.mock(UserDao.class);

		PowerMockito.when(mockDao.findEmailById(101)).thenCallRealMethod();

		UserService service = new UserService(mockDao);

		String email = service.getEmailByUserId(101);

		assertEquals("john.k@gmail.com", email);
	}

	@Test
	public void testDoProcess() {
		UserService mockService = PowerMockito.mock(UserService.class);
		try {
			PowerMockito.doNothing().when(mockService, "pushMsgToKafkaTopic", anyString());
			mockService.doProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDoWorkWithPrivateMethodMock() throws Exception {
		UserService service = new UserService();
		UserService spy = PowerMockito.spy(service);
		PowerMockito.doReturn("TEST MSG").when(spy, "formatMsg", "test msg");
		String formattedMsg = service.doWork("test msg");
		assertEquals("TEST MSG", formattedMsg);
	}
}
