package sanitas.david.calculadora.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	final static Logger logger = LogManager.getLogger(MainController.class);

	@GetMapping("calculadora")
	int calculadoraEntrada(@RequestParam(value = "operador1") String op1, @RequestParam(value = "operador2") String op2,
			@RequestParam(value = "operacion") String operacion) {
		
		int resultado = 0;
		boolean opOk1 = comprobarParametros(op1);
		boolean opOk2 = comprobarParametros(op2);
		
		if(opOk1 && opOk2) {
			
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
			
		} else {
			
			if(!opOk1) logger.error("Parámetro 1 no numérico");
			if(!opOk2) logger.error("Parámetro 2 no numérico");
		}
		
		return resultado;
	}
	
	private int sumaOperacion(String op1, String op2) {
		
		return Integer.parseInt(op1) + Integer.parseInt(op2);
	}
	
	private int restaOperacion(String op1, String op2) {
	
		return Integer.parseInt(op1) - Integer.parseInt(op2);
	}
	
	private boolean comprobarParametros(String param) {
		
		try {
			 Integer.parseInt(param);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
}
