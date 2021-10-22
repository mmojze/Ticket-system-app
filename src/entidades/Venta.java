package entidades;

import java.sql.Date;

public class Venta {
	
	private int idVenta;
	private Espectaculo espectaculo;
	private Ubicacion ubicacion;
	private Usuario vendedor;
	private Date fechaVenta;
	private String nombreCliente; 
	private int telefonoCliente; 
	private double total;

	public Venta(int idVenta, Espectaculo espectaculo, Date fechaVenta, String nombreCliente, int telefonoCliente, double total,
			Ubicacion ubicacion, Usuario usuario) {
		
		this.idVenta = idVenta;
		this.espectaculo = espectaculo;
		this.fechaVenta = fechaVenta; 
		this.nombreCliente = nombreCliente;
		this.telefonoCliente = telefonoCliente;
		this.total = total;
		this.ubicacion = ubicacion;
		this.vendedor = usuario;
		
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(int telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	


}
