package exceptions;

public class DAOErrorDeCierreBDException extends Exception {
	
	public DAOErrorDeCierreBDException() { 
	}
	
	public DAOErrorDeCierreBDException(String message) {
	 super(message); 
	}
	
	public DAOErrorDeCierreBDException(Throwable cause) {
	 super(cause);
	}
	
	public DAOErrorDeCierreBDException(String message, Throwable cause) {
	 super(message,cause);
	}

}
