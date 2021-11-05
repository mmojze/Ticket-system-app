package servicios;

import java.util.List;

import dao.UbicacionDAO;
import dao.UbicacionDAOH2;
import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.DAOException;
import exceptions.ServiceException;

public class UbicacionService {

	public UbicacionService() {

	}

	public Ubicacion consultarUbicacion(Ubicacion ubicacion) throws ServiceException {
		
		UbicacionDAO ubicacionDAO = new UbicacionDAOH2(); 
		
		try {
			ubicacion = ubicacionDAO.consultarUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return ubicacion;
	}
	
	public Ubicacion crearUbicacion(Ubicacion ubicacion) throws ServiceException {
		
		UbicacionDAO ubicacionDAO = new UbicacionDAOH2(); 
		
		try {
			ubicacion = ubicacionDAO.crearUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return ubicacion;
	}
	
	public Ubicacion modificarUbicacion(Ubicacion ubicacion) throws ServiceException { 
		
		UbicacionDAO ubicacionDAO = new UbicacionDAOH2(); 
		
		try {
			ubicacion = ubicacionDAO.modificarUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return ubicacion;
		
	}
	
	public void eliminarUbicacion(Ubicacion ubicacion ) throws ServiceException { 
		
		UbicacionDAO ubicacionDAO = new UbicacionDAOH2(); 
		
		try {
			ubicacionDAO.eliminarUbicacion(ubicacion);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		
	}
	
	public List<Ubicacion> listarUbicacionesPorLugar(Lugar lugar) throws ServiceException {
		
		UbicacionDAO ubicacionDAO = new UbicacionDAOH2(); 
		List<Ubicacion> ubicaciones;
		
		try {
			ubicaciones = ubicacionDAO.listarUbicacionesPorLugar(lugar);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return ubicaciones;
		
	}
}
