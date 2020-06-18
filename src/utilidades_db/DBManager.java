package utilidades_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_DIRECTORY = System.getProperty("user.dir");
	private static final String DB_BASE_URL = "jdbc:h2:" + DB_DIRECTORY + "\\db\\bd_tickets";
	private static final String DB_USERNAME = "admin";
	private static final String DB_PASSWORD = "admin"; 
	
	public static Connection connect() { 
		
		Connection c = null; 
		
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.exit(0);
		}
		
		try {
			c = DriverManager.getConnection(DB_BASE_URL, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
		
	}

}

