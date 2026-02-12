package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchParticularColRecords {

	public static void main(String[] args) {
		Connection con = null;
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT", "root", "rootroot");
			 Statement stmt = con.createStatement();
			 ResultSet result = stmt.executeQuery("select empno,ename,sal from emp");
			 while (result.next()) {
				 int empno = result.getInt(1);
				 System.out.println("empno : ");
			}
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
