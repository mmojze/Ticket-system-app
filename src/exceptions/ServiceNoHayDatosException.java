package exceptions;

public class ServiceNoHayDatosException extends Exception {

	public ServiceNoHayDatosException() {
	}

	public ServiceNoHayDatosException(String message) {
		super(message);
	}

	public ServiceNoHayDatosException(Throwable cause) {
		super(cause);
	}

	public ServiceNoHayDatosException(String message, Throwable cause) {
		super(message, cause);
	}

}
