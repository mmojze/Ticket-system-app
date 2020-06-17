package dao;
import java.util.List;

import entidades.Usuario;
import exceptions.DAONoHayResultadosException;

public interface UsuarioDAO {
	
	public List<String> buscarUsuario(String usuario, String contraseña) throws DAONoHayResultadosException; 
	
}
