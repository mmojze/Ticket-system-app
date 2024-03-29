package dao;

import entidades.Usuario;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAONoHayResultadosException;

public interface UsuarioDAO {

	public Usuario consultarUsuario(String usuario, String contraseņa) throws DAONoHayResultadosException,
			DAOErrorDeConexionBDException, DAOErrorDeCierreBDException, DAOErrorEjecucionSentenciaException;

}
