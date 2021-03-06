package br.com.ryan.select;

import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;

import org.junit.Test;

import br.com.ryan.connection.ConnectionInterface;
import br.com.ryan.connection.JDBC;

public class SelectTest {
	@Test
	public void testConexaoBancoDados() {
		ConnectionInterface DAO = new JDBC();
		ResultSet result = DAO.execute("SHOW TABLES");
		
		assertNotNull(result);
	}
}