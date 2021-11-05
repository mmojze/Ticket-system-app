package servicios;

import java.util.List;

import dao.EspectaculoDAO;
import dao.EspectaculoDAOH2;
import entidades.Espectaculo;
import exceptions.DAOException;
import exceptions.ServiceException;

public class EspectaculoService {

	public EspectaculoService() {

	}
	
	
	public Espectaculo consultarEspectaculo(Espectaculo espectaculo) throws ServiceException {
		
		EspectaculoDAO espectaculoDAO = new EspectaculoDAOH2(); 
		
		try {
			espectaculo = espectaculoDAO.consultarEspectaculo(espectaculo);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return espectaculo;
	}
	
	public Espectaculo crearEspectaculo(Espectaculo espectaculo) throws ServiceException {
		
		EspectaculoDAO espectaculoDAO = new EspectaculoDAOH2(); 
		
		try {
			espectaculo = espectaculoDAO.crearEspectaculo(espectaculo);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return espectaculo;
	}
	
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo) throws ServiceException { 
		
		EspectaculoDAO espectaculoDAO = new EspectaculoDAOH2(); 
		
		try {
			espectaculo = espectaculoDAO.modificarEspectaculo(espectaculo);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return espectaculo;
		
	}
	
	public void eliminarEspectaculo(Espectaculo espectaculo ) throws ServiceException { 
		
		EspectaculoDAO espectaculoDAO = new EspectaculoDAOH2(); 
		
		try {
			espectaculoDAO.eliminarEspectaculo(espectaculo);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		
	}
	
	public List<Espectaculo> listarEspectaculos() throws ServiceException {
		
		EspectaculoDAO espectaculoDAO = new EspectaculoDAOH2(); 
		List<Espectaculo> espectaculos;
		
		try {
			espectaculos = espectaculoDAO.listarEspectaculos();
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return espectaculos;
		
	}

}
