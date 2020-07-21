package exceptions;

public class DAOErrorEjecucionSentenciaException extends Exception {
	
	public DAOErrorEjecucionSentenciaException() {
	}

	public DAOErrorEjecucionSentenciaException(String message) {
		super(message);
	}

	public DAOErrorEjecucionSentenciaException(Throwable cause) {
		super(cause);
	}

	public DAOErrorEjecucionSentenciaException(String message, Throwable cause) {
		super(message, cause);
	}

}
