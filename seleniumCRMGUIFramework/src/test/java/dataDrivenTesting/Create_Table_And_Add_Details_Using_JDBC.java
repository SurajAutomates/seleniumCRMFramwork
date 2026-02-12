package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table_And_Add_Details_Using_JDBC {
	public static void main(String[] args) {
		Connection con = null;
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","rootroot");
			 Statement stmt = con.createStatement();
//			 int result = stmt.executeUpdate("create table demoQA_detail (firstname varchar(50),lastname  varchar(50), email varchar(100),mobile_no varchar(15) primary key)");
//			 
//			 System.out.println("--table created--");
			 
			 stmt.executeUpdate("INSERT INTO demoQA_detail (firstname, lastname, email, mobile_no) VALUES ('Suraj', 'Kadam', 'suraj@gmail.com', '9876543210')");
			 stmt.executeUpdate("INSERT INTO demoQA_detail (firstname, lastname, email, mobile_no) VALUES ('Kaustubh', 'Patil', 'kp@gmail.com', '9876543211')");
			 stmt.executeUpdate("INSERT INTO demoQA_detail (firstname, lastname, email, mobile_no) VALUES ('Krishna', 'Kamble', 'boss@gmail.com', '9876543212')");
			 
			 System.out.println("---Addedd data successfully---");
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
