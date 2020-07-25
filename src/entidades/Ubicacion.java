package entidades;

public class Ubicacion {

	private int idUbicacion;
	private String nombre;
	private Lugar lugar;
	private int capacidadUbicacion;
	private String fotoUbicacion;
	private int precioUbicacion;

	public Ubicacion() {

	}

	public Ubicacion(String nombre, Lugar lugar, int capacidadUbicacion) {

		this.nombre = nombre;
		this.lugar = lugar;
		this.capacidadUbicacion = capacidadUbicacion;

	}

	public Ubicacion(String nombre, int capacidadUbicacion) {

		this.nombre = nombre;
		this.capacidadUbicacion = capacidadUbicacion;

	}

	public Ubicacion(String nombre, int capacidadUbicacion, String fotoUbicacion) {

		this.nombre = nombre;
		this.capacidadUbicacion = capacidadUbicacion;
		this.fotoUbicacion = fotoUbicacion;

	}

	public Ubicacion(String nombre, int capacidadUbicacion, String fotoUbicacion, int idUbicacion) {

		this.nombre = nombre;
		this.capacidadUbicacion = capacidadUbicacion;
		this.fotoUbicacion = fotoUbicacion;
		this.idUbicacion = idUbicacion;

	}

	public Ubicacion(Lugar lugar, String nombre, int capacidadUbicacion) {

		this.nombre = nombre;
		this.capacidadUbicacion = capacidadUbicacion;
		this.lugar = lugar;

	}

	public Ubicacion(Lugar lugar, String nombre, int capacidadUbicacion, String fotoUbicacion) {

		this.nombre = nombre;
		this.capacidadUbicacion = capacidadUbicacion;
		this.lugar = lugar;
		this.fotoUbicacion = fotoUbicacion;
	}

	public Ubicacion(Lugar lugar, String nombre, int capacidadUbicacion, String fotoUbicacion, int idUbicacion) {

		this.nombre = nombre;
		this.capacidadUbicacion = capacidadUbicacion;
		this.lugar = lugar;
		this.fotoUbicacion = fotoUbicacion;
		this.idUbicacion = idUbicacion;
	}

	public int getCapacidadUbicacion() {
		return capacidadUbicacion;
	}

	public void setCapacidadUbicacion(int capacidadUbicacion) {
		this.capacidadUbicacion = capacidadUbicacion;
	}

	public int getPrecioUbicacion() {
		return precioUbicacion;
	}

	public void setPrecioUbicacion(int precioUbicacion) {
		this.precioUbicacion = precioUbicacion;
	}

	public int getIdUbicacion() {

		return this.idUbicacion;

	}

	public String getNombre() {

		return this.nombre;

	}

	public Lugar getLugar() {

		return this.lugar;

	}

	public int getCapacidad() {

		return this.capacidadUbicacion;

	}

	public String getFotoUbicacion() {

		return this.fotoUbicacion;

	}

	public void setIdUbicacion(int id) {

		this.idUbicacion = id;

	}

	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	public void setLugar(Lugar lugar) {

		this.lugar = lugar;

	}

	public void setCapacidad(int capacidadUbicacion) {

		this.capacidadUbicacion = capacidadUbicacion;

	}

	public void setFotoUbicacion(String archivofoto) {

		this.fotoUbicacion = archivofoto;

	}

}
