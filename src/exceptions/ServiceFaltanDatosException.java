package exceptions;

public class ServiceFaltanDatosException extends ServiceException {

	public ServiceFaltanDatosException() {
	}

	public ServiceFaltanDatosException(String message) {
		super(message);
	}

	public ServiceFaltanDatosException(Throwable cause) {
		super(cause);
	}

	public ServiceFaltanDatosException(String message, Throwable cause) {
		super(message, cause);
	}


}
