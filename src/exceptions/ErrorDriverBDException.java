package exceptions;

public class ErrorDriverBDException extends Exception {

	public ErrorDriverBDException() {
	}

	public ErrorDriverBDException(String message) {
		super(message);
	}

	public ErrorDriverBDException(Throwable cause) {
		super(cause);
	}

	public ErrorDriverBDException(String message, Throwable cause) {
		super(message, cause);
	}

}
