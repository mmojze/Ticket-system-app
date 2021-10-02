package servicios;

import java.util.List;

import dao.LugarDAO;
import dao.LugarDAOH2;
import entidades.Lugar;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAOErrorRollbackBDException;
import exceptions.DAONoHayResultadosException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceException;

public class LugarService {

	public LugarService() {

	}

	public int crearLugar(Lugar lugar)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		int idLugar;

		LugarDAO lugarDAO = new LugarDAOH2();
		try {
			idLugar = lugarDAO.crearLugar(lugar);
		} catch (DAOException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

		return idLugar;

	}

	public List<Lugar> listarLugares() throws ServiceErrorDeConexionBDException,
			ServiceErrorEjecucionSentenciaException, ServiceException {

		LugarDAO lugarDAO = new LugarDAOH2();
		List<Lugar> lugaresListados;

		try {
			lugaresListados = lugarDAO.listarLugares();
		} catch (DAOException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAONoHayResultadosException e) {
			throw new ServiceException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

		return lugaresListados;

	}

	public void borrarLugar(Lugar lugar)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		LugarDAO lugarDAO = new LugarDAOH2();

		try {
			lugarDAO.eliminarLugar(lugar);
		} catch (DAOException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}
	}

	public void modificarLugar(Lugar lugar)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		LugarDAO lugarDAO = new LugarDAOH2();

		try {
			lugarDAO.modificarLugar(lugar);
		} catch (DAOException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

	}

}
