package factories;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * factory method
 * 
 * */

public class ConnectionFactory {
	private String driver = "org.postgresql.Driver";
	private String host = "jdbc:postgresql://localhost:5432/db_prj_java";
	private String user = "postgres";
	private String password = "rei16703";
	
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(host,user,password);
	}
}
