package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Working_With_NinzaHr_DB {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
			
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from project");
			
			while(result.next()) {
				System.out.println(result.getString("project_id"));
				
			}
			
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
