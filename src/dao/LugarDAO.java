package dao;

import java.util.List;

import entidades.Lugar;
import exceptions.DAOException;

public interface LugarDAO {
	
	public Lugar crearLugar(Lugar lugar) throws DAOException;
	public Lugar modificarLugar(Lugar lugar) throws DAOException;
	public void eliminarLugar(Lugar lugar) throws DAOException;
	public Lugar consultarLugar(Lugar lugar) throws DAOException;
	public List<Lugar> listarLugares() throws DAOException;

}
