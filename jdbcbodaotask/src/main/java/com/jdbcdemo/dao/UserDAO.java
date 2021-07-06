package com.jdbcdemo.dao;

import java.util.List;

import com.jdbcdemo.model.User;

public interface UserDAO {
	public int registerUser(User use);
	public List<User> getAllUsers();
}
