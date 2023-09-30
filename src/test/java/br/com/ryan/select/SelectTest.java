package br.com.ryan.select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectTest {
	
	@Test
	void testConexaoBancoDados() {
		Assertions.assertDoesNotThrow(() -> Select.exibirResultados());
	}
}