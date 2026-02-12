package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Practice {
	public static void main(String[] args) throws SQLException {
//		Register driver → Create connection → Create statement → Execute query → Close connection
		
//		1. Register or load the driver
//In newer versions of JDBC,this step is usually not required because the driver is auto-loaded when the JAR is in the classpath.		
//		Driver driverRef = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driverRef);
		
//		2. Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT","root","rootroot");
		
//		3. Create a statement
		Statement stmt = con.createStatement();
		
//		4. Execute the query
		ResultSet result = stmt.executeQuery("select * from emp");
		
		while (result.next()) {
			System.out.println(result.getString("ename"));
		}
		
//		5. Close the connection
		con.close();
		
		System.out.println("completed");
	}
}
