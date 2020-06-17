package exceptions;

public class NumeroNegativoException extends Exception {
	
	public NumeroNegativoException() { 
	}
	
	public NumeroNegativoException(String message) {
	 super(message); 
	}
	
	public NumeroNegativoException(Throwable cause) {
	 super(cause);
	}
	
	public NumeroNegativoException(String message, Throwable cause) {
	 super(message,cause);
	}


}
