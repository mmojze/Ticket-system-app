package servicios;

import java.util.List;

import dao.VentaDAO;
import dao.VentaDAOH2;
import entidades.Venta;
import exceptions.DAOException;
import exceptions.ServiceException;

public class VentaService {

	public VentaService() {

	}
	
	public Venta consultarVenta(Venta venta) throws ServiceException {
		
		VentaDAO ventaDAO = new VentaDAOH2(); 
		
		try {
			venta = ventaDAO.consultarVenta(venta);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return venta;
	}
	
	public Venta crearVenta(Venta venta) throws ServiceException {
		
		VentaDAO ventaDAO = new VentaDAOH2(); 
		
		try {
			venta = ventaDAO.crearVenta(venta);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return venta;
	}
	
	public Venta modificarVenta(Venta venta) throws ServiceException { 
		
		VentaDAO ventaDAO = new VentaDAOH2(); 
		
		try {
			venta = ventaDAO.modificarVenta(venta);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return venta;
		
	}
	
	public void eliminarVenta(Venta venta) throws ServiceException { 
		
		VentaDAO ventaDAO = new VentaDAOH2(); 
		
		try {
			ventaDAO.eliminarVenta(venta);
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		
	}
	
	public List<Venta> listarVentas() throws ServiceException {
		
		VentaDAO ventaDAO = new VentaDAOH2(); 
		List<Venta> ventas;
		
		try {
			ventas = ventaDAO.listarVentas();
		} catch (DAOException e) {
			throw new ServiceException();
		};
		
		return ventas;
		
	}
}
