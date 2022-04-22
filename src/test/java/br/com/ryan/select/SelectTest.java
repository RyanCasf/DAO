package br.com.ryan.select;

import java.sql.ResultSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.ryan.connection.JDBC;

public class SelectTest {
	@Test
	public void testConexaoBancoDados() {
		ResultSet result = JDBC.execute("SHOW TABLES");
		System.out.println(result.toString());
		Assert.assertEquals(true, (result != null));
	}
}