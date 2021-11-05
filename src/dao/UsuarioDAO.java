package dao;

import java.util.List;

import entidades.Usuario;
import exceptions.DAOException;

public interface UsuarioDAO {

	public Usuario consultarUsuario(Usuario usuario) throws DAOException;
	public Usuario crearUsuario(Usuario usuario) throws DAOException;
	public Usuario modificarUsuario(Usuario usuario) throws DAOException;
	public void eliminarUsuario(Usuario usuario) throws DAOException;
	public List<Usuario> listarUsuarios() throws DAOException;

}
