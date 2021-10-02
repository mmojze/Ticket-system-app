package dao;

import entidades.Usuario;
import exceptions.DAOException;

public interface UsuarioDAO {

	public Usuario getUser(Usuario usuario) throws DAOException;

}
