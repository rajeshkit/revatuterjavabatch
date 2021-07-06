package com.jdbcdemo.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionSingleton {
	private static Connection con = null;
	private DBConnectionSingleton() {

	}

	public static Connection getConnectionInstance() {
		String url=null;
		String username=null;
		String password=null;
		try(FileInputStream fis=new FileInputStream("dbconfig.properties");){
			Properties prop=new Properties();
			prop.load(fis);
//			System.out.println(prop.getProperty("db.password"));
//			System.out.println(prop.getProperty("db.url"));
//			System.out.println(prop.getProperty("db.username"));
//			System.out.println(prop.getProperty("db.name"));
			url = prop.getProperty("db.url");
			username = prop.getProperty("db.username");
			password = prop.getProperty("db.password");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}

		return con;
	}
	public static void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
