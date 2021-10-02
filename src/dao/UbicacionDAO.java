package dao;

import java.util.List;

import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.DAOException;

public interface UbicacionDAO {
	
	public void crearUbicaciones(List<Ubicacion> ubicaciones) throws DAOException;
	public int crearUbicacion(Ubicacion ubicacion, Lugar lugar) throws DAOException;
	public void modificarUbicacion(Ubicacion ubicacion) throws DAOException;
	public void eliminarUbicacion(Ubicacion ubicacion) throws DAOException;
	public Ubicacion consultarUbicacion(Ubicacion ubicacion) throws DAOException;
	public List<Ubicacion> listarUbicacionesPorLugar(Lugar lugar) throws DAOException;
	 
}
