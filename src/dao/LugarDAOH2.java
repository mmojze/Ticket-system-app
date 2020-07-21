package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Lugar;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAOErrorRollbackBDException;
import exceptions.DAONoHayResultadosException;
import exceptions.ErrorCierreDeConexionException;
import exceptions.ErrorConexionBDException;
import exceptions.ErrorDriverBDException;
import exceptions.ErrorEjecucionDeSentenciaException;
import exceptions.ErrorRollbackBDExcepcion;
import utilidades_db.DBManager;
import utilidades_db.TableManager;

public class LugarDAOH2 implements LugarDAO {

	public int crearLugar(Lugar lugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException,
			DAOErrorRollbackBDException, DAOErrorDeCierreBDException {

		Connection conexion;
		int idGenerado = 0;

		try {
			conexion = DBManager.connect();
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
				} else {
					throw new DAOErrorEjecucionSentenciaException();
				}

			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					throw new DAOErrorRollbackBDException();
				}
				throw new DAOErrorEjecucionSentenciaException();
			} finally {

				try {
					conexion.close();
				} catch (SQLException e1) {
					throw new DAOErrorDeCierreBDException();
				}
			}

		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {
			throw new DAOErrorDeConexionBDException();
		}

		return idGenerado;

	}

	public void modificarLugar(Lugar lugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException,
			DAOErrorDeCierreBDException, DAOErrorRollbackBDException {

		Connection conexion;
		try {
			conexion = DBManager.connect();
		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {
			throw new DAOErrorDeConexionBDException();
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
				throw new DAOErrorRollbackBDException();
			}
			throw new DAOErrorEjecucionSentenciaException();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new DAOErrorDeCierreBDException();
			}
		}
	}

	public void eliminarLugar(int idLugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException {

		try {
			TableManager.borrarFila("LUGAR", "ID_LUGAR", idLugar);
		} catch (ErrorConexionBDException | ErrorRollbackBDExcepcion | ErrorCierreDeConexionException e) {
			throw new DAOErrorDeConexionBDException();
		} catch (ErrorEjecucionDeSentenciaException e1) {
			throw new DAOErrorEjecucionSentenciaException();
		}

	}

	public Lugar consultarLugar(int idLugar) throws DAOErrorDeConexionBDException, DAONoHayResultadosException,
			DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException {

		Connection conexion;
		Lugar lugarObtenido = new Lugar();
		try {
			conexion = DBManager.connect();
			String sentencia = "SELECT * FROM LUGAR WHERE ID_LUGAR = " + idLugar + ";";

			try {
				Statement s = conexion.createStatement();
				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();

				if (result.next() == false) {

					throw new DAONoHayResultadosException();

				} else {

					lugarObtenido = new Lugar(result.getString("NOMBRE"), result.getString("DIRECCION"),
							result.getInt("CAPACIDAD_TOTAL"), result.getString("NOMBRE_IMAGEN_LUGAR"),
							result.getInt("ID_LUGAR"));

					return lugarObtenido;

				}
			} catch (SQLException e) {
				throw new DAOErrorEjecucionSentenciaException();
			} finally {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new DAOErrorDeCierreBDException();
				}
			}
		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {
			throw new DAOErrorDeConexionBDException();
		}

	}

	public List<Lugar> listarLugares() throws DAOErrorDeConexionBDException, DAONoHayResultadosException,
			DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException {

		Connection conexion;

		try {
			conexion = DBManager.connect();
		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {
			throw new DAOErrorDeConexionBDException();
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
			throw new DAOErrorEjecucionSentenciaException();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new DAOErrorDeCierreBDException();
			}
		}

		return lugaresObtenidos;

	}

}
