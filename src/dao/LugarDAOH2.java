package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Lugar;
import exceptions.DAOException;
import utilidades_db.DBManager;
import utilidades_db.TableManager;

public class LugarDAOH2 implements LugarDAO {

	public Lugar crearLugar(Lugar lugar) throws DAOException {

		int idGenerado = 0;
		
		/*
		try {
			Connection conexion = DBManager.getInstance().getConnection();
			String sentencia = "INSERT INTO LUGAR(CAPACIDAD_TOTAL, NOMBRE, DIRECCION, NOMBRE_IMAGEN_LUGAR) VALUES ("
					+ lugar.getCapacidadTotal() + ", '" + lugar.getNombre() + "', '" + lugar.getDireccion() + "', '"
					+ lugar.getFotoLugar() + "');";

			try {
				PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
				int result = s.executeUpdate();
				conexion.commit();
				ResultSet rs = s.getGeneratedKeys();

				if (rs.next()) {
					idGenerado = rs.getInt(1);
				}

			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					throw new DAOException();
				}
				throw new DAOException();
			} finally {

				try {
					conexion.close();
				} catch (SQLException e1) {
					throw new DAOException ();
				}
			}

		} catch ( SQLException e2) {
			throw new DAOException();
		}

		return idGenerado;
		*/
		return null;
		

	}

	public Lugar modificarLugar(Lugar lugar) throws DAOException {
		
		/*
		Connection conexion;
		try {
			conexion = DBManager.getInstance().getConnection();
		} catch ( SQLException e2) {
			throw new DAOException();
		}

		Statement s;
		try {
			s = conexion.createStatement();
			String sentencia = "UPDATE LUGAR SET CAPACIDAD_TOTAL = " + lugar.getCapacidadTotal() + ", " + "NOMBRE = '"
					+ lugar.getNombre() + "' ," + "DIRECCION = '" + lugar.getDireccion() + "' ,"
					+ "NOMBRE_IMAGEN_LUGAR = '" + lugar.getFotoLugar() + "' WHERE ID_LUGAR = " + lugar.getIdLugar()
					+ ";";

			s.executeUpdate(sentencia);
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new DAOException();
			}
			throw new DAOException();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new DAOException();
			}
		}
		*/
		
		return null;
		
	}

	public void eliminarLugar(Lugar lugar) throws DAOException {
		
		/*
		try {
			TableManager.borrarFila("LUGAR", "ID_LUGAR", lugar.getIdLugar());
		} catch (ErrorConexionBDException | ErrorRollbackBDExcepcion | ErrorCierreDeConexionException e) {
			throw new DAOException();
		} catch (ErrorEjecucionDeSentenciaException e1) {
			throw new DAOErrorEjecucionSentenciaException();
		}
		*/

	}

	public Lugar consultarLugar(Lugar lugar) throws DAOException {

		Connection conexion;
		Lugar lugarObtenido = new Lugar();
		try {
			conexion = DBManager.getInstance().getConnection();;
			String sentencia = "SELECT * FROM LUGAR WHERE ID_LUGAR = " + lugar.getIdLugar() + ";";

			try {
				Statement s = conexion.createStatement();
				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();

				if (result.next() == false) {

					throw new DAOException();

				} else {

					lugarObtenido = new Lugar(result.getString("NOMBRE"), result.getString("DIRECCION"),
							result.getInt("CAPACIDAD_TOTAL"), result.getString("NOMBRE_IMAGEN_LUGAR"),
							result.getInt("ID_LUGAR"));

					return lugarObtenido;

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
		} catch (SQLException e2) {
			throw new DAOException();
		}

	}

	public List<Lugar> listarLugares() throws DAOException {

		Connection conexion;

		try {
			conexion = DBManager.getInstance().getConnection();;
		} catch (SQLException e2) {
			throw new DAOException();
		}

		List<Lugar> lugaresObtenidos = new ArrayList<Lugar>();

		String sentencia = "SELECT * FROM LUGAR;";

		try {
			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
			conexion.commit();

			while (result.next()) {
				Lugar lugar1 = new Lugar(result.getString("NOMBRE"), result.getString("DIRECCION"),
						result.getInt("CAPACIDAD_TOTAL"), result.getString("NOMBRE_IMAGEN_LUGAR"),
						result.getInt("ID_LUGAR"));

				lugaresObtenidos.add(lugar1);
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

		return lugaresObtenidos;

	}

}
