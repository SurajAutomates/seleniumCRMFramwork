package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtility {
	Connection con;
	public Connection connectToDB() throws Exception{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","rootroot");
		return con;
	}
	
	public void closeDBConnection(Connection con) throws SQLException {
		con.close();
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		return resultSet;
	}
	public void executeUpdate(String query) throws SQLException {
		Statement stmt = con.createStatement();
		int executeUpdate = stmt.executeUpdate(query);
	}
}
