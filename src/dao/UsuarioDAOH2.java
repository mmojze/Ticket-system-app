package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAONoHayResultadosException;
import utilidades_db.DBManager;

public class UsuarioDAOH2 implements UsuarioDAO {

	public Usuario consultarUsuario(String usuario, String contraseña)
			throws DAONoHayResultadosException, DAOErrorDeConexionBDException, DAOErrorDeCierreBDException {

		Connection conexion = DBManager.connect();

		String sentencia = "SELECT t1.NOMBRE_USUARIO, t1.NOMBRE , t1.APELLIDO, t2.NOMBRE_ROL "
				+ "FROM USUARIOS AS T1 "
				+ "INNER JOIN ROLES AS T2 ON t2.ID_ROL = t1.ID_ROL "
				+ "WHERE t1.NOMBRE_USUARIO = '" + usuario 
				+ "' AND t1.CONTRASEÑA = '" + contraseña + "';";

		Usuario usuarioObtenido = new Usuario();

		try {
			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
			conexion.commit();

			if (result.next() == false) {
				throw new DAONoHayResultadosException();
			} else {

				usuarioObtenido.setApellido(result.getString("APELLIDO"));
				usuarioObtenido.setNombre(result.getString("NOMBRE"));
				usuarioObtenido.setTipoUsuario(result.getString("NOMBRE_ROL"));
				usuarioObtenido.setUsuario(result.getString("NOMBRE_USUARIO"));

			}
		} catch (SQLException e) {
			throw new DAOErrorDeConexionBDException();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new DAOErrorDeCierreBDException();
			}
		}

		return usuarioObtenido;

	}

}
