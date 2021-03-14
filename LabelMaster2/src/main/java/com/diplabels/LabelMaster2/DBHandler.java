package com.diplabels.LabelMaster2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



//MYSQL  (e.g. via MySql Workbench)

//creating database
//CREATE DATABASE test;

// creating mysql database for this project:
//CREATE TABLE labels (
//id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//numbers VARCHAR(30) NOT NULL,
//reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

// inserting a sample record 
//INSERT INTO labels (numbers) values ('AA123');


public class DBHandler {

	String username = "root";
	String password = "root_root";

	String table = "labels";
	String databaseName = "test";
	String timezone="?serverTimezone=UTC";
	
	String url = "jdbc:mysql://127.0.0.1:3306/"+databaseName + timezone;
	
	
	Connection con = null;

	public DBHandler() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public boolean checkIfExist(String number) throws SQLException {

		con = DriverManager.getConnection(url, username, password);

		String sql1 = "select * from " + table + " where numbers = '" + number + "';";

		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql1);

		boolean result = false;
		if (rs.next() == false) {
			result = false;
		} else {
			result = true;
		}

		rs.close();
		con.close();

		return result;

	}

	public void addToDatabase(String number) throws SQLException {

		con = DriverManager.getConnection(url, username, password);

		String sql1 = "INSERT INTO " + table + " (numbers) values ('" + number + "');";

		Statement statement = con.createStatement();
		statement.executeUpdate(sql1);

		con.close();

	}

	public void delete(String number) throws SQLException {

		con = DriverManager.getConnection(url, username, password);

		String sql1 = "DELETE FROM " + table + " WHERE numbers ='" + number + "';";

		Statement statement = con.createStatement();
		statement.executeUpdate(sql1);

		con.close();

	}

}
