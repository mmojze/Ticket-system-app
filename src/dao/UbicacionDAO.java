package dao;

import java.util.List;

import entidades.Lugar;
import entidades.Ubicacion;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAOErrorRollbackBDException;
import exceptions.DAONoHayResultadosException;

public interface UbicacionDAO {
	
	public void crearUbicaciones(List<Ubicacion> ubicaciones) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException;
	public int crearUbicacion(Ubicacion ubicacion, Lugar lugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException;
	public void modificarUbicacion(Ubicacion ubicacion) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException, DAOErrorRollbackBDException;
	public void eliminarUbicacion(Ubicacion ubicacion) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException;
	public Ubicacion consultarUbicacion(Ubicacion ubicacion) throws DAOErrorDeConexionBDException, DAONoHayResultadosException, DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException;
	public List<Ubicacion> listarUbicacionesPorLugar(Lugar lugar) throws DAOErrorDeConexionBDException, DAONoHayResultadosException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException;
	 
}
