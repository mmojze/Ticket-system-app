package dao;

import java.util.List;

import entidades.Venta;
import exceptions.DAOErrorDeCierreBDException;
import exceptions.DAOErrorDeConexionBDException;
import exceptions.DAOErrorEjecucionSentenciaException;
import exceptions.DAOErrorRollbackBDException;
import exceptions.DAONoHayResultadosException;

public interface VentaDAO {
	
	public void crearVenta(Venta venta) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException;
	public void modificarVenta(Venta venta) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException, DAOErrorRollbackBDException;
	public void eliminarVenta(Venta venta) throws DAOErrorDeConexionBDException, DAOErrorEjecucionSentenciaException;
	public Venta consultarVenta(Venta venta) throws DAOErrorDeConexionBDException, DAONoHayResultadosException, DAOErrorEjecucionSentenciaException, DAOErrorDeCierreBDException;
	public List<Venta> listarVentas() throws DAOErrorDeConexionBDException, DAONoHayResultadosException, DAOErrorEjecucionSentenciaException, DAOErrorRollbackBDException, DAOErrorDeCierreBDException;

}
