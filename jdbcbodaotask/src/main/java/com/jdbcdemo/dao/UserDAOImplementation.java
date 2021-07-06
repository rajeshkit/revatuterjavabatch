package com.jdbcdemo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcdemo.config.DBConnectionSingleton;
import com.jdbcdemo.model.User;

public class UserDAOImplementation implements UserDAO {

	@Override
	public int registerUser(User use) {
		//jdbc code insert user data passed from client->bo->dao
		System.out.println(use.getUserId());
		System.out.println(use.getUserEmail());
		System.out.println(use.getUserName());
		System.out.println(use.getUserPassword());
		int result=0;
		try {
			PreparedStatement pstmt=(DBConnectionSingleton.getConnectionInstance())
					.prepareCall("insert into user values(?,?,?,?)");
			pstmt.setInt(1, use.getUserId());//use.getUserId()=600
			pstmt.setString(2, use.getUserName());//use.getUserName()//ajay
			pstmt.setString(3, use.getUserPassword());//ajay@123
			pstmt.setString(4, use.getUserEmail());//ajay@gmail.com
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public List<User> getAllUsers() {
		// jdbc code retrive all the user details
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
