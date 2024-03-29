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

public class UbicacionDAOH2 implements UbicacionDAO {

	public void crearUbicaciones(List<Ubicacion> ubicaciones) throws DAOErrorDeConexionBDException,
			DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException {

		try {
			Connection conexion = DBManager.connect();
			Statement s;

			try {

				s = conexion.createStatement();

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

		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {
			throw new DAOErrorDeConexionBDException();
		}

	}

	public int crearUbicacion(Ubicacion ubicacion, Lugar lugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException {

		Connection conexion;
		int idGenerado = 0;

		try {
			conexion = DBManager.connect();
			String sentencia = "INSERT INTO UBICACIONES(NOMBRE, ID_LUGAR, CAPACIDAD, NOMBRE_IMAGEN_UBICACION) VALUES ('"
					+ ubicacion.getNombre() + "', " + lugar.getIdLugar() + ", " + ubicacion.getCapacidad() + ", '"
					+ ubicacion.getFotoUbicacion() + "');";

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

	public void modificarUbicacion(Ubicacion ubicacion) throws DAOErrorDeConexionBDException,
			DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException, DAOErrorRollbackBDException {

		Connection conexion;
		try {
			conexion = DBManager.connect();
		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {
			throw new DAOErrorDeConexionBDException();
		}

		Statement s;
		try {
			s = conexion.createStatement();
			String sentencia = "UPDATE UBICACIONES SET CAPACIDAD = " + ubicacion.getCapacidad() + ", " + "NOMBRE = '"
					+ ubicacion.getNombre() + "' ," + "NOMBRE_IMAGEN_UBICACION = '" + ubicacion.getFotoUbicacion()
					+ "' WHERE ID_UBICACION = " + ubicacion.getIdUbicacion() + ";";

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

	public void eliminarUbicacion(int idUbicacion)
			throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException {

		try {
			TableManager.borrarFila("UBICACIONES", "ID_UBICACION", idUbicacion);
		} catch (ErrorConexionBDException | ErrorRollbackBDExcepcion | ErrorCierreDeConexionException e) {
			throw new DAOErrorDeConexionBDException();
		} catch (ErrorEjecucionDeSentenciaException e) {
			throw new DAOErrorEjecucionSentenciaException();
		}

	}

	public Ubicacion consultarUbicacion(int idUbicacion) throws DAOErrorDeConexionBDException,
			DAONoHayResultadosException, DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException {

		Connection conexion;
		Ubicacion ubicacionObtenida = new Ubicacion();
		try {
			conexion = DBManager.connect();
			String sentencia = "SELECT * FROM UBICACION WHERE ID_UBICACION = " + idUbicacion + ";";

			try {
				Statement s = conexion.createStatement();
				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();

				if (result.next() == false) {

					throw new DAONoHayResultadosException();

				} else {

					ubicacionObtenida = new Ubicacion(result.getString("NOMBRE"),
							result.getInt("NOMBRE_IMAGEN_UBICACION"), result.getString("NOMBRE_IMAGEN_UBICACION"));

					return ubicacionObtenida;

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

	public List<Ubicacion> listarUbicacionesPorLugar(int idLugar)
			throws DAOErrorDeConexionBDException, DAONoHayResultadosException, DAOErrorEjecucionSentenciaException,
			DAOErrorRollbackBDException, DAOErrorDeCierreBDException {

		Connection conexion;

		try {
			conexion = DBManager.connect();
		} catch (ErrorConexionBDException | ErrorDriverBDException e2) {
			throw new DAOErrorDeConexionBDException();
		}

		List<Ubicacion> ubicacionesObtenidas = new ArrayList<Ubicacion>();

		String sentencia = "SELECT * FROM UBICACIONES WHERE ID_LUGAR = " + idLugar + ";";

		try {
			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
			conexion.commit();

			while (result.next()) {
				Ubicacion ubicacion1 = new Ubicacion(result.getString("NOMBRE"),
						result.getInt("CAPACIDAD"), result.getString("NOMBRE_IMAGEN_UBICACION"), result.getInt("ID_UBICACION"));

				ubicacionesObtenidas.add(ubicacion1);
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

		return ubicacionesObtenidas;
	}

}
