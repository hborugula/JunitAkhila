package com.ashokit.dao;

public class UserDaoImpl implements UserDao {

	public String findNameById(Integer id) {
		System.out.println("findNameById() called");
		return "John";
	}

	public String findEmailById(Integer id) {
		System.out.println("findEmailById() called");
		return "john.k@gmail.com";
	}

}
