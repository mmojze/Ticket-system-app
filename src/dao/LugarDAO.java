package dao;

import java.util.List;

import entidades.Lugar;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAOErrorRollbackBDException;
import exceptions.DAONoHayResultadosException;

public interface LugarDAO {
	
	public int crearLugar(Lugar lugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException;
	public void modificarLugar(Lugar lugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException, DAOErrorRollbackBDException;
	public void eliminarLugar(int idLugar) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException;
	public Lugar consultarLugar(int idLugar) throws DAOErrorDeConexionBDException, DAONoHayResultadosException, DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException;
	public List<Lugar> listarLugares() throws DAOErrorDeConexionBDException, DAONoHayResultadosException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException;

}
