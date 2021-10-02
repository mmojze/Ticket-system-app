package servicios;

import dao.UsuarioDAO;
import dao.UsuarioDAOH2;
import entidades.Usuario;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAONoHayResultadosException;
import exceptions.ErrorConexionBDException;
import exceptions.NoSeEncontroUsuarioException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceException;

public class UsuarioService {

	public Usuario getUser(Usuario usuario) throws ServiceException,
			ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		UsuarioDAO UsuarioDAO = new UsuarioDAOH2();
		
		try {
			Usuario usuarioLogeado = UsuarioDAO.getUser(usuario);
			return usuarioLogeado;
		} catch (DAONoHayResultadosException a) {
			throw new ServiceException();
		} catch (DAOException | DAOErrorDeCierreBDException b) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

	}

}
