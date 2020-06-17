package exceptions;

public class NoEsPalabraException extends Exception {
	
	public NoEsPalabraException() { 
	}
	
	public NoEsPalabraException(String message) {
	 super(message); 
	}
	
	public NoEsPalabraException(Throwable cause) {
	 super(cause);
	}
	
	public NoEsPalabraException(String message, Throwable cause) {
	 super(message,cause);
	}

}
