package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Lugar;
import exceptions.DAONoHayResultadosException;
import utilidades_db.DBManager;
import utilidades_db.TableManager;

public class LugarDAOH2 implements LugarDAO {

	public int crearLugar(Lugar lugar) {

		Connection conexion = DBManager.connect();

		String sentencia = "INSERT INTO LUGAR(CAPACIDAD_TOTAL, NOMBRE, DIRECCION, NOMBRE_IMAGEN_LUGAR) VALUES (" + lugar.getCapacidadTotal()
				+ ", '" + lugar.getNombre() + "', '" + lugar.getDireccion() + "', '" + lugar.getFotoUbicacion() + "');";

		int idGenerado = 0;

		try {
			PreparedStatement s = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
			int result = s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();

			if (rs.next()) {
				idGenerado = rs.getInt(1);
			} else {
				System.out.println("nope");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return idGenerado;

	}

	public void modificarLugar() {

	}

	public void eliminarLugar(int idLugar) {

		TableManager.borrarFila("LUGAR", "ID_LUGAR", idLugar);

	}

	public void visualizarLugar() {

	}

}
