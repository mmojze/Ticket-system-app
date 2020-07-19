package dao;

import entidades.Usuario;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAONoHayResultadosException;

public interface UsuarioDAO {
	
	public Usuario consultarUsuario(String usuario, String contraseña) throws DAONoHayResultadosException, DAOErrorDeConexionBDException, DAOErrorDeCierreBDException; 
	
}
