package dao;

import entidades.Usuario;
import exceptions.DAONoHayResultadosException;

public interface UsuarioDAO {
	
	public Usuario consultarUsuario(String usuario, String contraseņa) throws DAONoHayResultadosException; 
	
}
