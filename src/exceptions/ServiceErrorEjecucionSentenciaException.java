package exceptions;

public class ServiceErrorEjecucionSentenciaException extends Exception {

	public ServiceErrorEjecucionSentenciaException() {
	}

	public ServiceErrorEjecucionSentenciaException(String message) {
		super(message);
	}

	public ServiceErrorEjecucionSentenciaException(Throwable cause) {
		super(cause);
	}

	public ServiceErrorEjecucionSentenciaException(String message, Throwable cause) {
		super(message, cause);
	}

}
