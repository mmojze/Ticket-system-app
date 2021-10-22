package entidades;

import java.sql.Date;

public class Espectaculo {
	
	private int idEspectaculo;
	private String nombreEspectaculo;
	private Lugar lugar;
	private Date fechaRealizacion;

	public Espectaculo(String nombreEspectaculo, Lugar lugar, Date fechaRealizacion, int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
		this.fechaRealizacion = fechaRealizacion;
		this.nombreEspectaculo = nombreEspectaculo;
		this.lugar = lugar;
		
	}

	public Espectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}

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

	public int getIdEspectaculo() {
		return idEspectaculo;
	}

	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}

}
