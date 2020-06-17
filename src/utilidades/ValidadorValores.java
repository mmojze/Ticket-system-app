package utilidades;

import exceptions.NoEsPalabraException;
import exceptions.NumeroNegativoException;
import exceptions.TextoVacioException;

public class ValidadorValores {

	public static void validarContenidoTexto(String Texto) throws TextoVacioException {
		if (Texto.length() == 0) {
			throw new TextoVacioException("Error, texto está vacío");
		}
	}

	public static void validarNumeroPositivo(int numero) throws NumeroNegativoException {

		if (numero <= 0) {
			throw new NumeroNegativoException("El numero no es positivo");
		}
	}

	public static void validarPalabra(String palabra) throws NoEsPalabraException {
		for (int i = 0; i < palabra.length(); i++) {

			if (Character.isDigit(palabra.charAt(i))) {

				throw new NoEsPalabraException("La palabra contiene un numero");

			}
		}

	}
}
