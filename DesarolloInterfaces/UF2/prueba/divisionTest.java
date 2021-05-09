package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class divisionTest {

	@Test
	public void test() {
		
		int resultado = ejercicio1.resultadoDivision(4, 2);
		int esperado = 2;
		
		assertEquals(esperado, resultado);
		
	}

}
