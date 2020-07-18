package entidades;

import java.sql.Date;

public class Venta {

	private Espectaculo espectaculo;
	private Usuario vendedor;
	private Date fechaVenta;
	private String banco;
	private String medioPago;
	private String descuentoBancario;
	private double total;

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

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public String getDescuentoBancario() {
		return descuentoBancario;
	}

	public void setDescuentoBancario(String descuentoBancario) {
		this.descuentoBancario = descuentoBancario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
