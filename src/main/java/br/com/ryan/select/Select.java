package br.com.ryan.select;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ryan.connection.ConnectionInterface;
import br.com.ryan.connection.JDBC;

public class Select {
	public static void main(String[] args) {
		exibirResultados();
	}

	public static void exibirResultados() {
		ConnectionInterface DAO = new JDBC();
		ResultSet result = DAO.execute(" SELECT * FROM pes01_pessoa ");

		try {
			while (result.next()) {
				System.out.printf("%d: %s\n", result.getInt("chave"), result.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}