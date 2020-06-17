package exceptions;

public class DAONoHayResultadosException extends Exception {

	public DAONoHayResultadosException() {
	}

	public DAONoHayResultadosException(String message) {
		super(message);
	}

	public DAONoHayResultadosException(Throwable cause) {
		super(cause);
	}

	public DAONoHayResultadosException(String message, Throwable cause) {
		super(message, cause);
	}

}
