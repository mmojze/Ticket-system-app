package servicios;

import java.util.List;

import dao.UbicacionDAO;
import dao.UbicacionDAOH2;
import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.DAOException;
import exceptions.ServiceException;
import exceptions.ServiceFaltanDatosException;

public class UbicacionService {

	public UbicacionService() {

	}

	public Ubicacion consultarUbicacion(Ubicacion ubicacion) throws ServiceException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		try {
			ubicacion = ubicacionDAO.consultarUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		;

		return ubicacion;
	}

	public Ubicacion crearUbicacion(Ubicacion ubicacion) throws ServiceException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		try {
			ubicacion = ubicacionDAO.crearUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		;

		return ubicacion;
	}

	public Ubicacion modificarUbicacion(Ubicacion ubicacion) throws ServiceException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		try {
			ubicacion = ubicacionDAO.modificarUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		;

		return ubicacion;

	}

	public void eliminarUbicacion(Ubicacion ubicacion) throws ServiceException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();

		try {
			ubicacionDAO.eliminarUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		;

	}

	public List<Ubicacion> listarUbicacionesPorLugar(Lugar lugar) throws ServiceException {

		UbicacionDAO ubicacionDAO = new UbicacionDAOH2();
		List<Ubicacion> ubicaciones;

		try {
			ubicaciones = ubicacionDAO.listarUbicacionesPorLugar(lugar);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		;

		return ubicaciones;

	}

	public List<Ubicacion> crearUbicacionesParaLugar(Lugar lugar) throws ServiceException {

		List<Ubicacion> ubicaciones = lugar.getUbicacionesLugar();
		int totalUbicaciones = 0;

		for (Ubicacion ubicacion : ubicaciones) {

			if (ubicacion.getCapacidad() < 0 || ubicacion.getNombre() == "") {
				throw new ServiceFaltanDatosException("Por favor, complete todos los datos obligatorios");
			}

			totalUbicaciones = totalUbicaciones + ubicacion.getCapacidad();

		}

		if (totalUbicaciones > lugar.getCapacidadTotal()) {

			throw new ServiceException(
					"La capacidad total del lugar es superada por la capacidad total de ubicaciones. Por favor, corrija la capacidad de las ubicaciones");

		}

		for (Ubicacion ubicacion : ubicaciones) {

			if (ubicacion.getIdUbicacion() == 0) {
				
				this.modificarUbicacion(ubicacion);
				
			} else {

				this.crearUbicacion(ubicacion);

			}

		}

		return ubicaciones;

	}

}
