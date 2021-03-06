package jdbcdemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerManagementSystem {
	public static void main(String[] args) {
	
		try {
			System.out.println(DBConnectionSingleton.getConnectionInstance().hashCode());
			Statement stmt=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where userid>200");
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
		updateUser();
		
		
	}

	private static void updateUser() {
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
     		Statement stmt=(DBConnectionSingleton.getConnectionInstance()).createStatement();
     		
			int result=stmt.executeUpdate("update user set username='"+uname+"',password='"+upass+"',email='"+uemail+"' where userid="+uid+"");
			if(result!=0) {
				System.out.println("User details got updated");
			}else {
				System.out.println("User details doesnot exists | not updated");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void deleteUser() {
		System.out.println(DBConnectionSingleton.getConnectionInstance().hashCode());
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the User ID you want to delete");
		int uid = s.nextInt();
		try {
				Statement stmt= (DBConnectionSingleton.getConnectionInstance()).createStatement();
			int result = stmt.executeUpdate("delete from user where userid="+uid+"");
			if(result!=0) {
				System.out.println("User details deleted");
			}else {
				System.out.println("User ID does not exists in the DB | details not deleted ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addUser() {
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
			Statement stmt=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			int result= stmt.executeUpdate("insert into user values("+uid+",'"+uname+"','"+upass+"','"+uemail+"')");
			if(result!=0) {
				System.out.println("User Details Added to the Database");
			}else {
				System.out.println("User Details Not Added to the Database");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnectionSingleton.closeConnection();
	}

}
