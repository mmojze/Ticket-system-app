package exceptions;

public class ArchivoNoExisteException extends Exception {
	
	public ArchivoNoExisteException() { 
	}
	
	public ArchivoNoExisteException(String message) {
	 super(message); 
	}
	
	public ArchivoNoExisteException(Throwable cause) {
	 super(cause);
	}
	
	public ArchivoNoExisteException(String message, Throwable cause) {
	 super(message,cause);
	}

}