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
import exceptions.DAONoHayResultadosException;
import utilidades_db.DBManager;
import utilidades_db.TableManager;

public class LugarDAOH2 implements LugarDAO {

	public int crearLugar(Lugar lugar) {

		Connection conexion = DBManager.connect();

		String sentencia = "INSERT INTO LUGAR(CAPACIDAD_TOTAL, NOMBRE, DIRECCION, NOMBRE_IMAGEN_LUGAR) VALUES ("
				+ lugar.getCapacidadTotal() + ", '" + lugar.getNombre() + "', '" + lugar.getDireccion() + "', '"
				+ lugar.getFotoLugar() + "');";

		int idGenerado = 0;

		try {
			PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
			int result = s.executeUpdate();
			conexion.commit();
			ResultSet rs = s.getGeneratedKeys();

			if (rs.next()) {
				idGenerado = rs.getInt(1);
			} else {
				throw new DAONoHayResultadosException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DAONoHayResultadosException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

		return idGenerado;

	}

	public void modificarLugar(Lugar lugar) {

		Connection conexion = DBManager.connect();
		Statement s;
		try {
			s = conexion.createStatement();

			String sentencia = "UPDATE LUGAR SET CAPACIDAD_TOTAL = " + lugar.getCapacidadTotal() + ", " + "NOMBRE = '"
					+ lugar.getNombre() + "' ," + "DIRECCION = '" + lugar.getDireccion() + "' ,"
					+ "NOMBRE_IMAGEN_LUGAR = '" + lugar.getFotoLugar() + "' WHERE ID_LUGAR = " + lugar.getIdLugar() + ";";

			s.executeUpdate(sentencia);
			conexion.commit();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}

	public void eliminarLugar(int idLugar) {

		TableManager.borrarFila("LUGAR", "ID_LUGAR", idLugar);

	}

	public Lugar consultarLugar(int idLugar) throws DAONoHayResultadosException {

		Connection conexion = DBManager.connect();

		String sentencia = "SELECT * FROM LUGAR WHERE ID_LUGAR = " + idLugar + ";";
		Lugar lugarObtenido = null;

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
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

		return lugarObtenido;

	}

	public List<Lugar> listarLugares() {
		Connection conexion = DBManager.connect();

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
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

		return lugaresObtenidos;

	}

}
