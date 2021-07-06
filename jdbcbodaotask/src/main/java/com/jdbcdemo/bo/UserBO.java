package com.jdbcdemo.bo;

import java.util.List;

import com.jdbcdemo.model.User;

public interface UserBO {
		public int addUser(User user);
		public List<User> getUsers();
}
