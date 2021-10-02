package dao;

import java.util.List;

import entidades.Espectaculo;
import exceptions.DAOException;

public interface EspectaculoDAO {
	
	public Espectaculo crearEspectaculo(Espectaculo espectaculo) throws DAOException;
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo) throws DAOException;
	public void eliminarEspectaculo(Espectaculo espectaculo) throws DAOException;
	public Espectaculo consultarEspectaculo(Espectaculo espectaculo) throws DAOException;
	public List<Espectaculo> listarEspectaculos() throws DAOException;

}
