package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Espectaculo;
import entidades.Ubicacion;
import entidades.Usuario;
import entidades.Venta;
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

	@Override
	public Usuario crearUsuario(Usuario usuario) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				/*
				String sentencia = "INSERT INTO VENTAS(ID_UBICACION, NOMBRE_USUARIO, FECHA_VENTA, NOMBRE_CLIENTE, TELEFONO_CLIENTE, TOTAL) "
						+ "VALUES (" + venta.getUbicacion().getIdUbicacion() + "', '" + venta.getVendedor().getUsuario()
						+ "', '" + venta.getFechaVenta() + "', '" + venta.getNombreCliente() + "', '"
						+ venta.getTelefonoCliente() + "', '" + venta.getTotal() + "');";

				PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
				int result = s.executeUpdate();
				conexion.commit();
				ResultSet rs = s.getGeneratedKeys();

				if (rs.next()) {
					venta.setIdVenta(rs.getInt(1));
				}
				*/
				
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
				
				/*

				Statement s = conexion.createStatement();

				String sentencia = "UPDATE LUGAR SET ID_UBICACION = " + venta.getUbicacion().getIdUbicacion() + ", "
						+ "NOMBRE_CLIENTE = '" + venta.getNombreCliente() + "' ," + "TELEFONO_CLIENTE = '"
						+ venta.getTelefonoCliente() + "' ," + "TOTAL = '" + venta.getTotal() + "' WHERE ID_VENTA = "
						+ venta.getIdVenta() + ";";

				s.executeUpdate(sentencia);
				conexion.commit();
				*/
				
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
		// TODO Auto-generated method stub
		
	}

	public List<Usuario> listarUsuarios(Usuario usuario) throws DAOException {
		
		Connection conexion;

		try {
			conexion = DBManager.getInstance().getConnection();
		} catch (SQLException e2) {
			throw new DAOException();
		}

		List<Usuario> usuariosObtenidos = new ArrayList<Usuario>();

		String sentencia = "SELECT * FROM USUARIO;";

		try {
			
			/*
			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
			conexion.commit();

			while (result.next()) {
				Venta venta = new Venta(
						result.getInt("ID_VENTA"), 
						new Espectaculo(result.getInt("ID_ESPECTACULO")), 
						result.getDate("FECHA_VENTA"),
						result.getString("NOMBRE_CLIENTE"),
						result.getInt("TELEFONO_CLIENTE"),
						result.getDouble("TOTAL"),
						new Ubicacion(result.getInt("ID_UBICACION")),
						new Usuario(result.getString("NOMBRE_USUARIO"))
						);

				ventasObtenidas.add(venta);
			}
			*/

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
