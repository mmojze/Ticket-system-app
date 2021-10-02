package servicios;

import java.util.List;

import dao.UbicacionDAO;
import dao.UbicacionDAOH2;
import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAOErrorRollbackBDException;
import exceptions.DAONoHayResultadosException;
import exceptions.ServiceErrorDeConexionBDException;
import exceptions.ServiceErrorEjecucionSentenciaException;
import exceptions.ServiceException;

public class UbicacionService {

	public UbicacionService() {

	}

	public void crearUbicaciones(List<Ubicacion> ubicaciones)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		try {
			ubicacionDAO.crearUbicaciones(ubicaciones);
		} catch (DAOException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

	}

	public int crearUbicacion(Ubicacion ubicacion, Lugar lugar)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		int idGenerado;

		try {
			idGenerado = ubicacionDAO.crearUbicacion(ubicacion, lugar);
		} catch (DAOException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

		return idGenerado;
	}

	public List<Ubicacion> listarUbicacionesPorLugar(Lugar lugar) throws ServiceErrorDeConexionBDException,
			ServiceErrorEjecucionSentenciaException, ServiceException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		List<Ubicacion> lugaresListados;
		try {
			lugaresListados = ubicacionDAO.listarUbicacionesPorLugar(lugar);
		} catch (DAOException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAONoHayResultadosException e) {
			throw new ServiceException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

		return lugaresListados;

	}

	public void borrarUbicacion(Ubicacion ubicacion)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		try {
			ubicacionDAO.eliminarUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}
	}

	public void modificarUbicacion(Ubicacion ubicacion)
			throws ServiceErrorDeConexionBDException, ServiceErrorEjecucionSentenciaException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		try {
			ubicacionDAO.modificarUbicacion(ubicacion);
		} catch (DAOException | DAOErrorRollbackBDException | DAOErrorDeCierreBDException e) {
			throw new ServiceErrorDeConexionBDException();
		} catch (DAOErrorEjecucionSentenciaException e) {
			throw new ServiceErrorEjecucionSentenciaException();
		}

	}
}
