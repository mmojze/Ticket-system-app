package dao;

import java.util.List;

import entidades.Venta;
import exceptions.DAOException;

public interface VentaDAO {
	
	public Venta crearVenta(Venta venta) throws DAOException;
	public Venta modificarVenta(Venta venta) throws DAOException;
	public void eliminarVenta(Venta venta) throws DAOException;
	public Venta consultarVenta(Venta venta) throws DAOException;
	public List<Venta> listarVentas() throws DAOException;

}
