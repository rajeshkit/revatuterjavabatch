package com.jdbcdemo.client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jedbcdemo.dao.UserDAO;
import com.jedbcdemo.dao.UserDaoImplementation;
import com.jedbcdemo.model.User;

public class CustomerManagementSystem {
	public static void main(String[] args) {
		System.out.println("User Management System");
		System.out.println("1. Add User");
		System.out.println("2. Update User");
		System.out.println("3. Delete User");
		System.out.println("4. Get All Users");
	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		int choice=s.nextInt();
		do{
		switch (choice) {
		case 1:{
			//addUser();
			System.out.println("Enter the user ID to be updated");
			int uid=s.nextInt();
			s.nextLine();
			System.out.println("Enter your new username");
			String uname = s.nextLine();
			System.out.println("Enter the new Password");
			String upass=s.nextLine();
			System.out.println("Enter the new email");
			String uemail=s.nextLine();
			UserDAO udao=new UserDaoImplementation();
			int status= udao.registerUser(uid, uname, upass, uemail);
			if(status!=0) {
				System.out.println("User Details Got Added to the DB");
			}else {
				System.out.println("User Details Not Got Added to the DB");
			}
			break;
		}
		case 2:
		{
			System.out.println("Enter the user ID to be updated");
			int uid=s.nextInt();
			s.nextLine();
			System.out.println("Enter your new username");
			String uname = s.nextLine();
			System.out.println("Enter the new Password");
			String upass=s.nextLine();
			System.out.println("Enter the new email");
			String uemail=s.nextLine();
			UserDAO udao = new UserDaoImplementation();
			int status=udao.updateUser(uid, uname, upass, uemail);
			if(status!=0) {
				System.out.println("User details got updated");
			}else {
				System.out.println("User details doesnot exists | not updated");
			}
			break;
			
		}
		case 3:
		{
			System.out.println("Enter the User ID you want to delete");
			int uid = s.nextInt();
			UserDAO udao = new UserDaoImplementation();
			int result = udao.deleteUser(uid);
			if(result!=0) {
				System.out.println("User details deleted");
			}else {
				System.out.println("User ID does not exists in the DB | details not deleted ");
			}
			break;
		}
		case 4:
		{
			UserDAO udao=new UserDaoImplementation();
			List<User> lu = udao.getUsers();
			for(User u:lu) {
				System.out.println("User ID: "+u.getUserId());
				System.out.println("User Name: "+u.getUserName());
				System.out.println("User Password: "+u.getUserPassword());
				System.out.println("User Email: "+u.getUserEmail());
				System.out.println("***********************************");
			}
			break;
		}
		default:
			System.out.println("Enter the correct Options");
			break;
		}
		}while(choice>5);
		
		
		
		
	}

}
