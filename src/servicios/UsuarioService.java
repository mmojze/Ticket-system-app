package servicios;

import java.util.List;
import dao.UsuarioDAO;
import dao.UsuarioDAOH2;
import entidades.Usuario;
import exceptions.DAOException;
import exceptions.ServiceException;

public class UsuarioService {

	public UsuarioService() {

	}

	public Usuario consultarUsuario(Usuario usuario) throws ServiceException {

		UsuarioDAO usuarioDAO = new UsuarioDAOH2();

		try {
			usuario = usuarioDAO.consultarUsuario(usuario);
		} catch (DAOException e) {
			throw new ServiceException();
		}

		return usuario;
	}

	public Usuario crearUsuario(Usuario usuario) throws ServiceException {

		UsuarioDAO usuarioDAO = new UsuarioDAOH2();

		try {
			usuario = usuarioDAO.crearUsuario(usuario);
		} catch (DAOException e) {
			throw new ServiceException();
		}

		return usuario;
	}

	public Usuario modificarUsuario(Usuario usuario) throws ServiceException {

		UsuarioDAO usuarioDAO = new UsuarioDAOH2();

		try {
			usuario = usuarioDAO.modificarUsuario(usuario);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		;

		return usuario;

	}

	public void eliminarUsuario(Usuario usuario) throws ServiceException {

		UsuarioDAO usuarioDAO = new UsuarioDAOH2();

		try {
			usuarioDAO.eliminarUsuario(usuario);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	

	}

	public List<Usuario> listarUsuarios() throws ServiceException {

		UsuarioDAO usuarioDAO = new UsuarioDAOH2();
		List<Usuario> usuarios;

		try {
			usuarios = usuarioDAO.listarUsuarios();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		;

		return usuarios;

	}

}
