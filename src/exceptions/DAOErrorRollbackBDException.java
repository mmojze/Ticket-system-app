package exceptions;

public class DAOErrorRollbackBDException extends Exception {

	public DAOErrorRollbackBDException() {
	}

	public DAOErrorRollbackBDException(String message) {
		super(message);
	}

	public DAOErrorRollbackBDException(Throwable cause) {
		super(cause);
	}

	public DAOErrorRollbackBDException(String message, Throwable cause) {
		super(message, cause);
	}

}
