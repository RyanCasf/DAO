package br.com.ryan.hibernate.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PessoaDAOTest {
	
	private PessoaDAO pessoaDAO;
	
	@BeforeEach
	void setUp() {
		pessoaDAO = new PessoaDAO();
	}
	
	@Nested
	class Pesquisar {
		
		@Test
		void aceito() {
			Assertions.assertDoesNotThrow(() -> pessoaDAO.pesquisar().forEach(System.out::println));
		}
	}
	
	@Nested
	class Historico {
		
		@Test
		void aceito() {
			Assertions.assertDoesNotThrow(() -> pessoaDAO.historico(2L));
		}
	}
}