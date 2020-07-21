package servicios;

import java.util.List;

import dao.LugarDAO;
import dao.LugarDAOH2;
import entidades.Lugar;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAOErrorRollbackBDException;
import exceptions.DAONoHayResultadosException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceNoHayDatosException;

public class LugarService {

	public LugarService() {

	}

	public void crearLugar(Lugar lugar)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		LugarDAO lugarDAO = new LugarDAOH2();
		try {
			int idLugar = lugarDAO.crearLugar(lugar);
		} catch (DAOErrorDeConexionBDException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

	}

	public List<Lugar> listarLugares() throws ServiceErrorDeConexionBDException,
			ServiceErrorEjecucionSentenciaException, ServiceNoHayDatosException {

		LugarDAO lugarDAO = new LugarDAOH2();
		List<Lugar> lugaresListados;
		try {
			lugaresListados = lugarDAO.listarLugares();
		} catch (DAOErrorDeConexionBDException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAONoHayResultadosException e) {
			throw new ServiceNoHayDatosException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

		return lugaresListados;

	}

	public void borrarLugar(Lugar lugar)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		LugarDAO lugarDAO = new LugarDAOH2();
		try {
			lugarDAO.eliminarLugar(lugar.getIdLugar());
		} catch (DAOErrorDeConexionBDException e) {
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
		} catch (DAOErrorDeConexionBDException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

	}

}
