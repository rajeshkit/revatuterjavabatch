package com.jedbcdemo.dao;

import java.util.List;

import com.jedbcdemo.model.User;

public interface UserDAO {
	public int registerUser(int id,String name,String password,String email);
	public int updateUser(int id,String nname,String npassword,String nemail);
	public int deleteUser(int userId);
	public List<User> getUsers();
}
