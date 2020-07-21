package exceptions;

public class ErrorEjecucionDeSentenciaException extends Exception {
	
	public ErrorEjecucionDeSentenciaException() {
	}

	public ErrorEjecucionDeSentenciaException(String message) {
		super(message);
	}

	public ErrorEjecucionDeSentenciaException(Throwable cause) {
		super(cause);
	}

	public ErrorEjecucionDeSentenciaException(String message, Throwable cause) {
		super(message, cause);
	}

}
