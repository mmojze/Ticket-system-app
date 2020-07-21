package utilidades_db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.ErrorCierreDeConexionException;
import exceptions.ErrorConexionBDException;
import exceptions.ErrorDriverBDException;
import exceptions.ErrorEjecucionDeSentenciaException;
import exceptions.ErrorRollbackBDExcepcion;

public class TableManager {

	public static void borrarFila(String tabla, String primaryKey, int id) throws ErrorConexionBDException, ErrorEjecucionDeSentenciaException, ErrorRollbackBDExcepcion, ErrorCierreDeConexionException {

		Connection conexion;
		try {
			conexion = DBManager.connect();
		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {

			throw new ErrorConexionBDException();

		}

		String sentencia = "DELETE FROM " + tabla + " WHERE " + primaryKey + " = " + id + ";";

		Statement s;
		
		try {
			s = conexion.createStatement();
			int result = s.executeUpdate(sentencia);
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new ErrorRollbackBDExcepcion();
			}
			throw new ErrorEjecucionDeSentenciaException();
			
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new ErrorCierreDeConexionException();
			}
		}

	}

}
