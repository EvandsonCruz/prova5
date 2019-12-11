package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
	
	private Connection c;
	
	Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=prova4;namedPipes=true", "evandson4", "123456");
		System.out.println("Conexão ok");
		return c;
	}

}
