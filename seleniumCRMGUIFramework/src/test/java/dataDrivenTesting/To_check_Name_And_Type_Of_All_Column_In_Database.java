package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class To_check_Name_And_Type_Of_All_Column_In_Database {
	public static void main(String[] args) {

		Connection con = null;
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT", "root", "rootroot");
			 Statement stmt = con.createStatement();
			 ResultSet result = stmt.executeQuery("select empno,ename,sal from emp");
//	getMetaData() → gives column information   .   getColumnCount() → returns total number of columns
			 int columnCount = result.getMetaData().getColumnCount();
			 
			 for(int i = 1;i<=columnCount;i++) {
				 String columnName = result.getMetaData().getColumnName(i);
				 String columnType = result.getMetaData().getColumnTypeName(i);
				 
				 System.out.println(columnName+"|"+columnType);
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
