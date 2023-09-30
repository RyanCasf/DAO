package br.com.ryan.select;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ryan.connection.ConnectionInterface;
import br.com.ryan.connection.JDBC;

public class Select {
	
	public static void exibirResultados() {
		ConnectionInterface jdbc = new JDBC();
		ResultSet result = jdbc.execute(" SELECT * FROM pes01_pessoa ");
		
		if (result == null) {
			System.err.println("Conexão com banco de dados não foi encontrada!");
			return;
		}
		
		try {
			while (result.next()) {
				System.out.printf("%d: %s%n", result.getInt("chave"), result.getString("nome"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}