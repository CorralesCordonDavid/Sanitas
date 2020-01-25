package sanitas.david.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MainControllerTest {

	@Test
	void calculadoraEntrada() {
		MainController mc = new MainController();
		assertEquals(0, mc.calculadoraEntrada("a", "0", "suma"));
		assertEquals(0, mc.calculadoraEntrada("1", "a", "suma"));
		assertEquals(0, mc.calculadoraEntrada("a", "a", "suma"));
		assertEquals(0, mc.calculadoraEntrada("1", "0", "multiplicacion"));
		
		assertEquals(2, mc.calculadoraEntrada("1", "1", "suma"));
		assertNotEquals(1, mc.calculadoraEntrada("1", "3", "suma"));
		
		assertEquals(0, mc.calculadoraEntrada("1", "1", "resta"));
		assertNotEquals(0, mc.calculadoraEntrada("1", "3", "resta"));
		
		
	}

}
