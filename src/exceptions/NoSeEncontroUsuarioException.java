package exceptions;

public class NoSeEncontroUsuarioException extends Exception{

	public NoSeEncontroUsuarioException() {
	}

	public NoSeEncontroUsuarioException(String message) {
		super(message);
	}

	public NoSeEncontroUsuarioException(Throwable cause) {
		super(cause);
	}

	public NoSeEncontroUsuarioException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
