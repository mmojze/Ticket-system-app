package dao;

import entidades.Usuario;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAONoHayResultadosException;

public interface UsuarioDAO {

	public Usuario getUser(Usuario usuario) throws DAONoHayResultadosException,
			DAOErrorDeConexionBDException, DAOErrorDeCierreBDException, DAOErrorEjecucionSentenciaException;

}
