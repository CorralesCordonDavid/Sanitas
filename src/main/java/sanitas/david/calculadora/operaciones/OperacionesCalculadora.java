package sanitas.david.calculadora.operaciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OperacionesCalculadora {
	
	final static Logger logger = LogManager.getLogger(OperacionesCalculadora.class);

	
	public int opera(String operacion, String op1, String op2) {
		
		int resultado = 0;
		switch (operacion.toLowerCase()) {
		case "suma":
			resultado = sumaOperacion(op1,op2);
			break;
		case "resta":
			resultado = restaOperacion(op1,op2);
			break;
		default:
			logger.error("El parámetro operacion no coincide con ninguna operación implementada.");
			break;
		}
		
		return resultado;
	}
	
private int sumaOperacion(String op1, String op2) {
		
		return Integer.parseInt(op1) + Integer.parseInt(op2);
	}
	
	private int restaOperacion(String op1, String op2) {
	
		return Integer.parseInt(op1) - Integer.parseInt(op2);
	}

}
