package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Espectaculo;
import entidades.Venta;
import exceptions.DAOException;
import utilidades_db.DBManager;

public class VentaDAOH2 implements VentaDAO {

	public Venta crearVenta(Venta venta) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				/*
				String sentencia = "INSERT INTO LUGAR(CAPACIDAD_TOTAL, NOMBRE, DIRECCION, NOMBRE_IMAGEN_LUGAR) VALUES ("
						+ lugar.getCapacidadTotal() + ", '" + lugar.getNombre() + "', '" + lugar.getDireccion() + "', '"
						+ lugar.getFotoLugar() + "');";
				PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
				int result = s.executeUpdate();
				conexion.commit();
				ResultSet rs = s.getGeneratedKeys();

				if (rs.next()) {
					lugar.setIdLugar(rs.getInt(1));
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

		return venta;
		
	}

	public Venta modificarVenta(Venta venta) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				/*
				Statement s = conexion.createStatement();
				String sentencia = "UPDATE LUGAR SET CAPACIDAD_TOTAL = " + lugar.getCapacidadTotal() + ", "
						+ "NOMBRE = '" + lugar.getNombre() + "' ," + "DIRECCION = '" + lugar.getDireccion() + "' ,"
						+ "NOMBRE_IMAGEN_LUGAR = '" + lugar.getFotoLugar() + "' WHERE ID_LUGAR = " + lugar.getIdLugar()
						+ ";";

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

		return venta;
		
	}

	
	public void eliminarVenta(Venta venta) throws DAOException {
		
		
	}

	
	public Venta consultarVenta(Venta venta) throws DAOException {
	
		try {
			Connection conexion = DBManager.getInstance().getConnection();
			
			try {
				
				/*
				
				Statement s = conexion.createStatement();
				String sentencia = "SELECT * FROM LUGAR WHERE ID_LUGAR = " + lugar.getIdLugar() + ";";
				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();

				if (result.next() == false) {

					throw new DAOException();

				} else {
					
					lugar.setNombre(result.getString("NOMBRE"));
					lugar.setDireccion(result.getString("DIRECCION"));
					lugar.setCapacidadTotal(result.getInt("CAPACIDAD_TOTAL"));
					lugar.setFotoLugar(result.getString("NOMBRE_IMAGEN_LUGAR"));
					lugar.setIdLugar(result.getInt("ID_LUGAR"));
					
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
			
			/*
			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
			conexion.commit();

			while (result.next()) {
				Lugar lugar1 = new Lugar(result.getString("NOMBRE"), result.getString("DIRECCION"),
						result.getInt("CAPACIDAD_TOTAL"), result.getString("NOMBRE_IMAGEN_LUGAR"),
						result.getInt("ID_LUGAR"));

				lugaresObtenidos.add(lugar1);
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

		return ventasObtenidas;
		
	}

}
