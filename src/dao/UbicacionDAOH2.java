package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.DAOException;
import utilidades_db.DBManager;
import utilidades_db.TableManager;

public class UbicacionDAOH2 implements UbicacionDAO {

	public void crearUbicaciones(List<Ubicacion> ubicaciones) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				Statement s = conexion.createStatement();

				for (int i = 0; i < ubicaciones.size(); i++) {
					Ubicacion ubicacion = ubicaciones.get(i);
					String sentencia = "INSERT INTO UBICACIONES(NOMBRE, ID_LUGAR, CAPACIDAD, NOMBRE_IMAGEN_UBICACION) VALUES ('"
							+ ubicacion.getNombre() + "', " + ubicacion.getLugar().getIdLugar() + ", "
							+ ubicacion.getCapacidad() + ", '" + ubicacion.getFotoUbicacion() + "');";
					s.addBatch(sentencia);
				}

				s.executeBatch();
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

	public Ubicacion crearUbicacion(Ubicacion ubicacion) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				String sentencia = "INSERT INTO UBICACIONES(NOMBRE, ID_LUGAR, CAPACIDAD, NOMBRE_IMAGEN_UBICACION) VALUES ('"
						+ ubicacion.getNombre() + "', " + ubicacion.getLugar().getIdLugar() + ", " + ubicacion.getCapacidad() + ", '"
						+ ubicacion.getFotoUbicacion() + "');";

				PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
				s.executeUpdate();
				conexion.commit();
				ResultSet rs = s.getGeneratedKeys();

				if (rs.next()) {
					ubicacion.setIdUbicacion(rs.getInt(1));
				} else {
					throw new DAOException();
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
		
		return ubicacion;

	}

	public Ubicacion modificarUbicacion(Ubicacion ubicacion) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				Statement s = conexion.createStatement();
				String sentencia = "UPDATE UBICACIONES SET CAPACIDAD = " + ubicacion.getCapacidad() + ", " + "NOMBRE = '"
						+ ubicacion.getNombre() + "' ," + "NOMBRE_IMAGEN_UBICACION = '" + ubicacion.getFotoUbicacion()
						+ "' WHERE ID_UBICACION = " + ubicacion.getIdUbicacion() + ";";

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
		
		return ubicacion;

	}

	public void eliminarUbicacion(Ubicacion ubicacion) throws DAOException {

		/*
		 * try { TableManager.borrarFila("UBICACIONES", "ID_UBICACION",
		 * ubicacion.getIdUbicacion()); } catch (SQLException e) { throw new
		 * DAOException(); }
		 */

	}

	public Ubicacion consultarUbicacion(Ubicacion ubicacion) throws DAOException {
				
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				String sentencia = "SELECT * FROM UBICACION WHERE ID_UBICACION = " + ubicacion.getIdUbicacion() + ";";
				Statement s = conexion.createStatement();
				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();
				
				if (result.next() == false) {
					throw new DAOException();
				} else {
					ubicacion.setNombre(result.getString("NOMBRE"));
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
		
		return ubicacion;

	}

	public List<Ubicacion> listarUbicacionesPorLugar(Lugar lugar) throws DAOException {
		
		List<Ubicacion> ubicacionesObtenidas = new ArrayList<Ubicacion>();
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				String sentencia = "SELECT * FROM UBICACIONES WHERE ID_LUGAR = " + lugar.getIdLugar() + ";";
				Statement s = conexion.createStatement();
				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();

				while (result.next()) {
					Ubicacion ubicacion1 = new Ubicacion(result.getString("NOMBRE"), result.getInt("CAPACIDAD"),
							result.getString("NOMBRE_IMAGEN_UBICACION"), result.getInt("ID_UBICACION"));

					ubicacionesObtenidas.add(ubicacion1);
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
		
		return ubicacionesObtenidas;
		
	}

}
