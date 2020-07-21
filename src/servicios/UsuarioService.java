package servicios;

import dao.UsuarioDAO;
import dao.UsuarioDAOH2;
import entidades.Usuario;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAONoHayResultadosException;
import exceptions.ErrorConexionBDException;
import exceptions.NoSeEncontroUsuarioException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceNoHayDatosException;

public class UsuarioService {

	public Usuario logearse(String usuario, String contraseña) throws ServiceNoHayDatosException,
			ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		UsuarioDAO UsuarioDAO = new UsuarioDAOH2();
		Usuario usuarioLogeado = new Usuario();
		try {
			usuarioLogeado = UsuarioDAO.consultarUsuario(usuario, contraseña);
		} catch (DAONoHayResultadosException a) {
			throw new ServiceNoHayDatosException();
		} catch (DAOErrorDeConexionBDException | DAOErrorDeCierreBDException b) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

		return usuarioLogeado;

	}

}
