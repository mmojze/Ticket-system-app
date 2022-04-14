package servicios;

import java.util.List;

import dao.LugarDAO;
import dao.LugarDAOH2;
import entidades.Lugar;
import exceptions.DAOException;
import exceptions.ServiceException;
import exceptions.ServiceFaltanDatosException;

public class LugarService {

	public LugarService() {

	}

	public Lugar crearLugar(Lugar lugar) throws ServiceException {

		LugarDAO lugarDAO = new LugarDAOH2();
		
		if (lugar.getDireccion() == "" || lugar.getNombre() == "" || lugar.getCapacidadTotal() < 1 ) {
			throw new ServiceFaltanDatosException("Por favor, complete los datos obligatorios del lugar");
		}
		
		try {
			lugar = lugarDAO.crearLugar(lugar);
		} catch (DAOException e) {
			throw new ServiceException();
		};

		return lugar;

	}
	
	public Lugar consultarLugar(Lugar lugar) throws ServiceException {
		
		LugarDAO lugarDAO = new LugarDAOH2();
		
		try {
			lugar = lugarDAO.consultarLugar(lugar);
		} catch (DAOException e) {
			throw new ServiceException();
		};

		return lugar;
		
	}

	public List<Lugar> listarLugares() throws ServiceException {

		LugarDAO lugarDAO = new LugarDAOH2();
		List<Lugar> lugaresListados;

		try {
			lugaresListados = lugarDAO.listarLugares();
		} catch (DAOException e) {
			throw new ServiceException();
		} 

		return lugaresListados;

	}

	public void borrarLugar(Lugar lugar) throws ServiceException {

		LugarDAO lugarDAO = new LugarDAOH2();

		try {
			lugarDAO.eliminarLugar(lugar);
		} catch (DAOException e) {
			throw new ServiceException();
		} 
	}

	public Lugar modificarLugar(Lugar lugar) throws ServiceException {

		LugarDAO lugarDAO = new LugarDAOH2();

		try {
			lugar = lugarDAO.modificarLugar(lugar);
		} catch (DAOException e) {
			throw new ServiceException();
		} 
		
		return lugar;

	}

}
