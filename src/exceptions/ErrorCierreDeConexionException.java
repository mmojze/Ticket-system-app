package exceptions;

public class ErrorCierreDeConexionException extends Exception {
	
	public ErrorCierreDeConexionException() {
	}

	public ErrorCierreDeConexionException(String message) {
		super(message);
	}

	public ErrorCierreDeConexionException(Throwable cause) {
		super(cause);
	}

	public ErrorCierreDeConexionException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
