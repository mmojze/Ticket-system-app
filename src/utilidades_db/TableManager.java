package utilidades_db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {


public static void borrarFila(String tabla, String primaryKey, int id) { 
	
	Connection conexion = DBManager.connect();
	
	String sentencia = "DELETE FROM " + tabla + " WHERE " + primaryKey + " = " + id + ";";
	
	Statement s;
	try {
		s = conexion.createStatement();
		int result = s.executeUpdate(sentencia);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally { 
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}



}
