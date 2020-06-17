package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import exceptions.DAONoHayResultadosException;
import utilidades_db.DBManager;

public class UsuarioDAOH2 implements UsuarioDAO {

	public List<String> buscarUsuario(String usuario, String contraseña) throws DAONoHayResultadosException {
		
		
		Connection conexion = DBManager.connect();
		
		String sentencia = "SELECT t1.NOMBRE_USUARIO, t1.NOMBRE , t1.APELLIDO, t2.NOMBRE_ROL FROM USUARIOS AS T1 INNER JOIN ROLES AS T2 ON t2.ID_ROL = t1.ID_ROL WHERE t1.NOMBRE_USUARIO = '" + usuario + "' AND t1.CONTRASEÑA = '" + contraseña + "';";
		
		try {
			Statement s = conexion.createStatement();
			ResultSet result = s.executeQuery(sentencia);
				
		      if (result.next() == false) { // No existe el usuario
		          throw new DAONoHayResultadosException();
		        } else { // Se encuentra el usuario 
		        	List<String> usuarioObtenido = new ArrayList<>();
		        	
		        	usuarioObtenido.add(result.getString("NOMBRE_USUARIO"));
		        	usuarioObtenido.add(result.getString("NOMBRE"));
		        	usuarioObtenido.add(result.getString("APELLIDO"));
		        	usuarioObtenido.add(result.getString("NOMBRE_ROL"));
		        	
		        	return usuarioObtenido;
		        	
		          //do {
		            //String data = result.getString("emp_name");
		           // System.out.println(data);
		          //} while (rs.next());
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
		return null;

	}

}
