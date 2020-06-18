package dao;

import java.util.List;

import entidades.Lugar;
import exceptions.DAONoHayResultadosException;

public interface LugarDAO {
	
	public int crearLugar(Lugar lugar);
	public void modificarLugar(Lugar lugar);
	public void eliminarLugar(int idLugar);
	public Lugar consultarLugar(int idLugar) throws DAONoHayResultadosException;
	public List<Lugar> listarLugares();

}
