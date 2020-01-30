package sanitas.david.calculadora.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sanitas.david.calculadora.operaciones.OperacionesCalculadora;
import sanitas.david.calculadora.utilidades.Validaciones;

@RestController
public class MainController {
	
	final static Logger logger = LogManager.getLogger(MainController.class);

	@GetMapping("calculadora")
	int calculadoraEntrada(@RequestParam(value = "operador1") String op1, @RequestParam(value = "operador2") String op2,
			@RequestParam(value = "operacion") String operacion) {
		
		int resultado = 0;
		boolean opOk1 = Validaciones.comprobarParametros(op1);
		boolean opOk2 = Validaciones.comprobarParametros(op2);
		
		if(opOk1 && opOk2) {
			OperacionesCalculadora oc = new OperacionesCalculadora();
			resultado = oc.opera(operacion, op1, op2);
		
		} else {
			
			if(!opOk1) logger.error("Parámetro 1 no numérico");
			if(!opOk2) logger.error("Parámetro 2 no numérico");
		}
		
		return resultado;
	}
	
	
	
	
}
