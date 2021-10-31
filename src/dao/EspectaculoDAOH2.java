package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Espectaculo;
import entidades.Lugar;
import exceptions.DAOException;
import utilidades_db.DBManager;

public class EspectaculoDAOH2 implements EspectaculoDAO {

	public Espectaculo crearEspectaculo(Espectaculo espectaculo) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				String sentencia = "INSERT INTO ESPECTACULO(NOMBRE_ESPECTACULO, FECHA_ESPECTAUCLO, ID_LUGAR) VALUES ("
						+ espectaculo.getNombreEspectaculo() + "', '" + espectaculo.getFechaRealizacion() + "', '"
						+ espectaculo.getLugar().getIdLugar() + "');";
				PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
				int result = s.executeUpdate();
				conexion.commit();
				ResultSet rs = s.getGeneratedKeys();

				if (rs.next()) {
					espectaculo.setIdEspectaculo(rs.getInt(1));
				}
				;

			} catch (SQLException e) {
				conexion.rollback();
				throw new DAOException();
			} finally {
				conexion.close();
			}

		} catch (SQLException e) {
			throw new DAOException();
		}

		return espectaculo;

	}

	public Espectaculo modificarEspectaculo(Espectaculo espectaculo) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				Statement s = conexion.createStatement();

				String sentencia = "UPDATE ESPECTACULOS SET NOMBRE_ESPECTACULO = " + espectaculo.getNombreEspectaculo()
						+ ", " + "FECHA_ESPECTACULO = '" + espectaculo.getFechaRealizacion() + "' ," + "ID_LUGAR = '"
						+ espectaculo.getLugar().getIdLugar() + "' WHERE ID_ESPECTACULO = "
						+ espectaculo.getIdEspectaculo() + ";";

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

		return espectaculo;

	}

	public void eliminarEspectaculo(Espectaculo espectaculo) throws DAOException {
		
		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {
				
				Statement s = conexion.createStatement();

				String sentencia = "DELETE FROM ESPECTACULOS" + " WHERE ID_ESPECTACULO = " + espectaculo.getIdEspectaculo() + ";";

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

	public Espectaculo consultarEspectaculo(Espectaculo espectaculo) throws DAOException {

		try {
			Connection conexion = DBManager.getInstance().getConnection();

			try {

				Statement s = conexion.createStatement();

				String sentencia = "SELECT * FROM ESPECTACULOS WHERE ID_ESPECTACULO = " + espectaculo.getIdEspectaculo()
						+ ";";

				ResultSet result = s.executeQuery(sentencia);
				conexion.commit();

				if (result.next() == false) {

					throw new DAOException();

				} else {

					espectaculo.setNombreEspectaculo(result.getString("NOMBRE_ESPECTACULO"));
					espectaculo.setLugar(new Lugar(result.getInt("ID_LUGAR")));
					espectaculo.setFechaRealizacion(result.getDate("FECHA_ESPECTACULO"));

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

		return espectaculo;

	}

	public List<Espectaculo> listarEspectaculos() throws DAOException {

		Connection conexion;

		try {
			conexion = DBManager.getInstance().getConnection();
		} catch (SQLException e2) {
			throw new DAOException();
		}

		List<Espectaculo> espectaculosObtenidos = new ArrayList<Espectaculo>();

		String sentencia = "SELECT * FROM ESPECTACULOS;";

		try {

			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
			conexion.commit();
			while (result.next()) {
				Espectaculo espectaculo = new Espectaculo(result.getString("NOMBRE_ESPECTACULO"),
						new Lugar(result.getInt("ID_LUGAR")), result.getDate("FECHA_ESPECTACULO"),
						result.getInt("ID_ESPECTACULO"));

				espectaculosObtenidos.add(espectaculo);
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

		return espectaculosObtenidos;

	}

}
