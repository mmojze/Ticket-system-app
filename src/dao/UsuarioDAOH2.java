package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import exceptions.DAOException;
import utilidades_db.DBManager;

public class UsuarioDAOH2 implements UsuarioDAO {

	public Usuario consultarUsuario(Usuario usuario) throws DAOException {

		Usuario usuarioObtenido = new Usuario();

		try {
			Connection conexion = DBManager.getInstance().getConnection();
			String sentencia = "SELECT t1.NOMBRE_USUARIO, t1.NOMBRE , t1.APELLIDO, t2.NOMBRE_ROL "
					+ "FROM USUARIOS AS T1 " + "INNER JOIN ROLES AS T2 ON t2.ID_ROL = t1.ID_ROL "
					+ "WHERE t1.NOMBRE_USUARIO = '" + usuario.getUsuario() + "' AND t1.CONTRASEÑA = '"
					+ usuario.getContraseña() + "';";
			try {
				Statement s = conexion.createStatement();
				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();
				if (result.next() == false) {
					throw new DAOException();
				} else {

					usuarioObtenido.setApellido(result.getString("APELLIDO"));
					usuarioObtenido.setNombre(result.getString("NOMBRE"));
					usuarioObtenido.setTipoUsuario(result.getString("NOMBRE_ROL"));
					usuarioObtenido.setUsuario(result.getString("NOMBRE_USUARIO"));

				}
			} catch (SQLException e) {
				throw new DAOException();
			} finally {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new DAOException();
				}
			}
		} catch (SQLException e1) {
			throw new DAOException();
		}

		return usuarioObtenido;

	}

	public Usuario crearUsuario(Usuario usuario) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				String sentencia = "INSERT INTO USUARIOS(NOMBRE_USUARIO, NOMBRE, APELLIDO, CONTRASEÑA, ID_ROL) "
						+ "VALUES (" + usuario.getUsuario() + "', '" + usuario.getNombre()
						+ "', '" + usuario.getApellido() + "', '"
						+ usuario.getContraseña() + "', '" + usuario.getTipoUsuario() + "');";

				PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
				int result = s.executeUpdate();
				conexion.commit();
				
			} catch (SQLException e) {
				conexion.rollback();
				throw new DAOException();
			} finally {
				conexion.close();
			}

		} catch (SQLException e) {
			throw new DAOException();
		}

		return usuario;
	}

	public Usuario modificarUsuario(Usuario usuario) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				Statement s = conexion.createStatement();

				String sentencia = "USUARIOS LUGAR SET NOMBRE = " + usuario.getNombre() + ", "
						+ "APELLIDO = '" + usuario.getApellido() + "' ," + "CONTRASEÑA = '"
						+ usuario.getContraseña() + "' WHERE NOMBRE_USUARIO = "
						+ usuario.getUsuario() + ";";

				s.executeUpdate(sentencia);
				conexion.commit();
				
			} catch (SQLException e) {
				conexion.rollback();
				throw new DAOException();
			} finally {
				conexion.close();
			}

		} catch (SQLException e) {
			throw new DAOException();
		}

		return usuario;
		
	}

	public void eliminarUsuario(Usuario usuario) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				Statement s = conexion.createStatement();

				String sentencia = "DELETE FROM USUARIOS" + " WHERE NOMBRE_USUARIO = " + usuario.getUsuario() + ";";

				s.executeUpdate(sentencia);
				conexion.commit();
				
			} catch (SQLException e) {
				conexion.rollback();
				throw new DAOException();
			} finally {
				conexion.close();
			}

		} catch (SQLException e) {
			throw new DAOException();
		}
				
	}

	public List<Usuario> listarUsuarios() throws DAOException {
		
		Connection conexion;

		try {
			conexion = DBManager.getInstance().getConnection();
		} catch (SQLException e2) {
			throw new DAOException();
		}

		List<Usuario> usuariosObtenidos = new ArrayList<Usuario>();

		String sentencia = "SELECT * FROM USUARIOS;";

		try {
			
			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
			conexion.commit();

			while (result.next()) {
				Usuario usuarioObtenido = new Usuario(
						result.getString("NOMBRE_USUARIO"),
						result.getString("NOMBRE"),
						result.getString("APELLIDO"),
						result.getString("ID_ROL")
						);

				usuariosObtenidos.add(usuarioObtenido);
			}

		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new DAOException();
			}
		}

		return usuariosObtenidos;
		
	}

}
