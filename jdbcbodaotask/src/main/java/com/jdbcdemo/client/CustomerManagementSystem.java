package com.jdbcdemo.client;

import java.util.List;
import java.util.Scanner;

import com.jdbcdemo.bo.UserBO;
import com.jdbcdemo.bo.UserBOImplementation;
import com.jdbcdemo.model.User;

public class CustomerManagementSystem {
	public static void main(String[] args) {
		System.out.println("User Management System");
		System.out.println("1. Add User");
		System.out.println("2. Update User");
		System.out.println("3. Delete User");
		System.out.println("4. Get All Users");
		System.out.println("5. Get User By ID");
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
			User user=new User();
			user.setUserId(uid);
			user.setUserName(uname);
			user.setUserPassword(upass);
			user.setUserEmail(uemail);
			UserBO ubo=new UserBOImplementation();
			int state=ubo.addUser(user);
			if(state!=0) {
				System.out.println("Userdetails added successfully");
			}else {
				System.out.println("Userdetails Not added successfully");
			}
			break;
		}
		case 2:
		{
//			System.out.println("Enter the user ID to be updated");
//			int uid=s.nextInt();
//			s.nextLine();
//			System.out.println("Enter your new username");
//			String uname = s.nextLine();
//			System.out.println("Enter the new Password");
//			String upass=s.nextLine();
//			System.out.println("Enter the new email");
//			String uemail=s.nextLine();
//			UserDAO udao = new UserDaoImplementation();
//			User user=new User();
//			user.setUserId(uid);
//			user.setUserName(uname);
//			user.setUserPassword(upass);
//			user.setUserEmail(uemail);
//			int status=udao.updateUser(user);
//			if(status!=0) {
//				System.out.println("User details got updated");
//			}else {
//				System.out.println("User details doesnot exists | not updated");
//			}
			break;
			
		}
		case 3:
		{
//			System.out.println("Enter the User ID you want to delete");
//			int uid = s.nextInt();
//			UserDAO udao = new UserDaoImplementation();
//			int result = udao.deleteUser(uid);
//			if(result!=0) {
//				System.out.println("User details deleted");
//			}else {
//				System.out.println("User ID does not exists in the DB | details not deleted ");
//			}
			break;
		}
		case 4:
		{
			UserBO ubo=new UserBOImplementation();
			List<User> lu=ubo.getUsers();
			for(User u:lu) {
				System.out.println("User ID: "+u.getUserId());
				System.out.println("User Name: "+u.getUserName());
				System.out.println("User Password: "+u.getUserPassword());
				System.out.println("User Email: "+u.getUserEmail());
				System.out.println("***********************************");
			}
			break;
		}
		case 5:
		{
//			System.out.println("Enter the User ID you want to delete");
//			int uid = s.nextInt();
//			UserDAO udao=new UserDaoImplementation();
//			User user=udao.getUserById(uid);//101010
//			System.out.println(user.getUserId());//500
//			System.out.println(user.getUserName());//reshmi
//			System.out.println(user.getUserPassword());//reshmi@123
//			System.out.println(user.getUserEmail());//reshmi@gmail.com
			break;
		}
		default:
			System.out.println("Enter the correct Options");
			break;
		}
		}while(choice>=5);
		
		
		
		
	}

}
