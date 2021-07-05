package jdbcdemo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
		case 1:
			addUser();
			break;
		case 2:
			updateUser();
			break;
		case 3:
			deleteUser();
			break;
		case 4:
			getUsers();
			break;
		default:
			System.out.println("Enter the correct Options");
			break;
		}
		}while(choice>5);
		
		
		
		
	}

	private static void getUsers() {
		try {
			System.out.println(DBConnectionSingleton.getConnectionInstance().hashCode());
		//	Statement stmt=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			PreparedStatement pstmt=(DBConnectionSingleton.getConnectionInstance())
					.prepareStatement("select * from user where username like ?");
//			ResultSet rs=stmt.executeQuery("select * from user where userid>200");
			pstmt.setString(1, "%a%");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));//400
				System.out.println(rs.getString(2));//vinay
				System.out.println(rs.getString(3));//vinay@123
				System.out.println(rs.getString(4));//vinay@gmail.com
				System.out.println("********************************");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void updateUser() {
		PreparedStatement pstmt=null;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the user ID to be updated");
		int uid=s.nextInt();
		s.nextLine();
		System.out.println("Enter your new username");
		String uname = s.nextLine();
		System.out.println("Enter the new Password");
		String upass=s.nextLine();
		System.out.println("Enter the new email");
		String uemail=s.nextLine();
		try {
			System.out.println(DBConnectionSingleton.getConnectionInstance().hashCode());
     		//Statement stmt=(DBConnectionSingleton.getConnectionInstance()).createStatement();
     		pstmt=(DBConnectionSingleton.getConnectionInstance())
     				.prepareStatement("update user set username=?,password=?,email=? where userid=?");
     		pstmt.setString(1, uname);
     		pstmt.setString(2, upass);
     		pstmt.setString(3, uemail);
     		pstmt.setInt(4, uid);
			int result=pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("User details got updated");
			}else {
				System.out.println("User details doesnot exists | not updated");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.close();
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void deleteUser() {
		PreparedStatement pstmt=null;
		System.out.println(DBConnectionSingleton.getConnectionInstance().hashCode());
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the User ID you want to delete");
		int uid = s.nextInt();
		try {
				//Statement stmt= (DBConnectionSingleton.getConnectionInstance()).createStatement();
				pstmt=(DBConnectionSingleton.getConnectionInstance())
						.prepareStatement("delete from user where userid=?");
				pstmt.setInt(1, uid);
			int result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("User details deleted");
			}else {
				System.out.println("User ID does not exists in the DB | details not deleted ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.close();
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void addUser() {
		PreparedStatement pstmt=null;
		System.out.println("Enter the User Details");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the User ID:");
		int uid=s.nextInt();
		s.nextLine();
		System.out.println("Enter your username");
		String uname = s.nextLine();
		System.out.println("Enter the Password");
		String upass=s.nextLine();
		System.out.println("Enter the email");
		String uemail=s.nextLine();
		
		try {
			System.out.println(DBConnectionSingleton.getConnectionInstance().hashCode());
			//Statement stmt=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			pstmt=(DBConnectionSingleton.getConnectionInstance())
					.prepareStatement("insert into user values(?,?,?,?)");
			pstmt.setInt(1,uid);
			pstmt.setString(2, uname);
			pstmt.setString(3, upass);
			pstmt.setString(4, uemail);
			int result= pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("User Details Added to the Database");
			}else {
				System.out.println("User Details Not Added to the Database");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.close();
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DBConnectionSingleton.closeConnection();
	}

}
