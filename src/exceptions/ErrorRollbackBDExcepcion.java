package exceptions;

public class ErrorRollbackBDExcepcion extends Exception {
	
	public ErrorRollbackBDExcepcion() {
	}

	public ErrorRollbackBDExcepcion(String message) {
		super(message);
	}

	public ErrorRollbackBDExcepcion(Throwable cause) {
		super(cause);
	}

	public ErrorRollbackBDExcepcion(String message, Throwable cause) {
		super(message, cause);
	}

}
