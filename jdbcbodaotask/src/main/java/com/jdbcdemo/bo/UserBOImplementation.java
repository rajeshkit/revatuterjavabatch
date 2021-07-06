package com.jdbcdemo.bo;

import java.util.List;

import com.jdbcdemo.dao.UserDAO;
import com.jdbcdemo.dao.UserDAOImplementation;
import com.jdbcdemo.model.User;

public class UserBOImplementation implements UserBO {

	@Override
	public int addUser(User user) {
		UserDAO udao=new UserDAOImplementation();
		int status =udao.registerUser(user);
		return status;
	}

	@Override
	public List<User> getUsers() {
		UserDAO udao=new UserDAOImplementation();
		List<User> usersList = udao.getAllUsers();
		return usersList;
	}
	

}
