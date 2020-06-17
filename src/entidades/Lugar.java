package entidades;

import java.util.List;

import dao.LugarDAO;
import dao.LugarDAOH2;

public class Lugar {
	
	private int idLugar;
	private int capacidadTotal; 
	private String nombre;
	private String direccion;
	private String fotoLugar;
	
	public Lugar(String nombre, String direccion, int capacidadTotal) { 
		
		this.capacidadTotal = capacidadTotal;
		this.direccion = direccion;
		this.nombre = nombre;
		
	}
	
	public Lugar(String nombre, String direccion, int capacidadTotal, String fotoLugar) { 
		
		this.capacidadTotal = capacidadTotal;
		this.direccion = direccion;
		this.nombre = nombre;
		this.fotoLugar = fotoLugar;
		
	}
	
	public void setCapacidadTotal(int capacidad) { 
		
		this.capacidadTotal = capacidad;
		
	}
	
	public void setNombre(String nombre) { 
		
		this.nombre = nombre;
		
	}
	
	public void setIdLugar(int id) { 
		
		this.idLugar = id;
		
	}
	
	public void setDireccion(String direccion) { 
		
		this.direccion = direccion;
		
	}
	
	public void setFotoLugar(String foto) { 
		
		this.fotoLugar = foto;
		
	}
	
	public int getCapacidadTotal() {  
		
		return this.capacidadTotal;
		
	}
	
	public String getDireccion() {  
		
		return this.direccion;
		
	}
	
	public String getNombre() {  
		
		return this.nombre;
		
	}
	
	public int getIdLugar() {  
		
		return this.idLugar;
		
	}
	
	
	public String getFotoUbicacion() {
		
		return this.fotoLugar;
				
	}
	
}
