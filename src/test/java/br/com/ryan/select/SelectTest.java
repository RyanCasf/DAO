package br.com.ryan.select;

import java.sql.ResultSet;
import org.junit.Assert;
import br.com.ryan.connection.JDBC;

public class SelectTest 
{
	@org.junit.Test
	public void testConexaoBancoDados()
	{
		ResultSet result = JDBC.execute("SHOW TABLES");
		Assert.assertEquals(true, (result != null));
	}
}