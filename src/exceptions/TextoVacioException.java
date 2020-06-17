package exceptions;

public class TextoVacioException extends Exception {
	
	public TextoVacioException() { 
	}
	
	public TextoVacioException(String message) {
	 super(message); 
	}
	
	public TextoVacioException(Throwable cause) {
	 super(cause);
	}
	
	public TextoVacioException(String message, Throwable cause) {
	 super(message,cause);
	}

}
