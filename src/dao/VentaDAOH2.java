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

public class VentaDAOH2 implements VentaDAO {

	public Venta crearVenta(Venta venta) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

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

			} catch (SQLException e) {
				conexion.rollback();
				throw new DAOException();
			} finally {
				conexion.close();
			}

		} catch (SQLException e) {
			throw new DAOException();
		}

		return venta;

	}

	public Venta modificarVenta(Venta venta) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				Statement s = conexion.createStatement();

				String sentencia = "UPDATE LUGAR SET ID_UBICACION = " + venta.getUbicacion().getIdUbicacion() + ", "
						+ "NOMBRE_CLIENTE = '" + venta.getNombreCliente() + "' ," + "TELEFONO_CLIENTE = '"
						+ venta.getTelefonoCliente() + "' ," + "TOTAL = '" + venta.getTotal() + "' WHERE ID_VENTA = "
						+ venta.getIdVenta() + ";";

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

		return venta;

	}

	public void eliminarVenta(Venta venta) throws DAOException {

	}

	public Venta consultarVenta(Venta venta) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				Statement s = conexion.createStatement();
				String sentencia = "SELECT * FROM VENTAS WHERE ID_VENTA = " + venta.getIdVenta() + ";";

				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();

				if (result.next() == false) {

					throw new DAOException();

				} else {

					venta.setEspectaculo(new Espectaculo(result.getInt("ID_ESPECTACULO")));
					venta.setFechaVenta(result.getDate("FECHA_VENTA"));
					venta.setIdVenta(result.getInt("ID_VENTA"));
					venta.setNombreCliente(result.getString("NOMBRE_CLIENTE"));
					venta.setTelefonoCliente(result.getInt("TELEFONO_CLIENTE"));
					venta.setTotal(result.getDouble("TOTAL"));
					venta.setUbicacion(new Ubicacion(result.getInt("ID_UBICACION")));
					venta.setVendedor(new Usuario(result.getString("NOMBRE_USUARIO")));

				}

			} catch (SQLException e) {
				conexion.rollback();
				throw new DAOException();
			} finally {
				conexion.close();
			}

		} catch (SQLException e) {
			throw new DAOException();
		}

		return venta;

	}

	public List<Venta> listarVentas() throws DAOException {

		Connection conexion;

		try {
			conexion = DBManager.getInstance().getConnection();
		} catch (SQLException e2) {
			throw new DAOException();
		}

		List<Venta> ventasObtenidas = new ArrayList<Venta>();

		String sentencia = "SELECT * FROM LUGAR;";

		try {

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

		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new DAOException();
			}
		}

		return ventasObtenidas;

	}

}
