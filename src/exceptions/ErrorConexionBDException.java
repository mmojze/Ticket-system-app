package exceptions;

public class ErrorConexionBDException extends Exception {

	public ErrorConexionBDException() { 
	}

	public ErrorConexionBDException(String message) {
	 super(message); 
	}

	public ErrorConexionBDException(Throwable cause) {
	 super(cause);
	}

	public ErrorConexionBDException(String message, Throwable cause) {
	 super(message,cause);
	 
	}

}
