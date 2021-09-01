package entidades;

public class Usuario {

	private String nombre;
	private String apellido;
	private String usuario;
	private String tipoUsuario;
	private String contraseña;
	
	public Usuario(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public Usuario() {

	}

	public String getTipoUsuario() {

		return this.tipoUsuario;

	}

	public String getNombre() {

		return this.nombre;

	}

	public String getApellido() {

		return this.apellido;

	}

	public String getUsuario() {

		return this.usuario;

	}

	public void setTipoUsuario(String tipoUsuario) {

		this.tipoUsuario = tipoUsuario;

	}

	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	public void setApellido(String apellido) {

		this.apellido = apellido;

	}

	public void setUsuario(String usuario) {

		this.usuario = usuario;

	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
