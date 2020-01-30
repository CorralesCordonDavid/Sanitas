package sanitas.david.calculadora.utilidades;

public class Validaciones {

	public static boolean comprobarParametros(String param) {

		try {
			Integer.parseInt(param);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

}
