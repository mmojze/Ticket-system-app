package exceptions;

public class DAOErrorDeConexionBDException extends Exception {

	public DAOErrorDeConexionBDException() {
	}

	public DAOErrorDeConexionBDException(String message) {
		super(message);
	}

	public DAOErrorDeConexionBDException(Throwable cause) {
		super(cause);
	}

	public DAOErrorDeConexionBDException(String message, Throwable cause) {
		super(message, cause);
	}

}
