package com.jedbcdemo.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcdemo.config.DBConnectionSingleton;
import com.jedbcdemo.model.User;

public class UserDaoImplementation implements UserDAO{

	@Override
	public int registerUser(int id, String name, String password, String email) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			PreparedStatement pstmt=(DBConnectionSingleton.getConnectionInstance())
					.prepareCall("insert into user values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateUser(int id, String nname, String npassword, String nemail) {
		int result=0;
		try {
			PreparedStatement pstmt=(DBConnectionSingleton.getConnectionInstance())
					.prepareCall("update user set username=?,password=?,email=? where userid=?");
			pstmt.setString(1, nname);
			pstmt.setString(2, npassword);
			pstmt.setString(3, nemail);
			pstmt.setInt(4, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteUser(int userId) {
		int result=0;
		try {
			PreparedStatement pstmt=(DBConnectionSingleton.getConnectionInstance())
					.prepareCall("delete from user where userid=?");
			pstmt.setInt(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<User> getUsers() {
		List<User> listOfUser=null;
		try {
			PreparedStatement pstmt=(DBConnectionSingleton.getConnectionInstance())
					.prepareCall("select * from user");
			ResultSet rs = pstmt.executeQuery();
			listOfUser=new ArrayList<User>();
			while(rs.next()) {
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserEmail(rs.getString(4));
				listOfUser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfUser;
	}

}
