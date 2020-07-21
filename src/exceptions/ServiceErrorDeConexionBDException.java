package exceptions;

public class ServiceErrorDeConexionBDException extends Exception {
	
	public ServiceErrorDeConexionBDException() {
	}

	public ServiceErrorDeConexionBDException(String message) {
		super(message);
	}

	public ServiceErrorDeConexionBDException(Throwable cause) {
		super(cause);
	}

	public ServiceErrorDeConexionBDException(String message, Throwable cause) {
		super(message, cause);
	}

}
