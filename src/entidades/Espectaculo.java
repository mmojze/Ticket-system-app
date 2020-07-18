package entidades;

import java.sql.Date;

public class Espectaculo {

	private String nombreEspectaculo;
	private Lugar lugar;
	private Date fechaRealizacion;

	public void setNombreEspectaculo(String nombreEspectaculo) {

		this.nombreEspectaculo = nombreEspectaculo;

	}

	public void setLugar(Lugar lugar) {

		this.lugar = lugar;

	}

	public void setFechaRealizacion(Date fechaRealizacion) {

		this.fechaRealizacion = fechaRealizacion;

	}

	public String getNombreEspectaculo() {

		return this.nombreEspectaculo;

	}

	public Lugar getLugar() {

		return this.lugar;

	}

	public Date getFechaRealizacion() {

		return this.fechaRealizacion;

	}

}
