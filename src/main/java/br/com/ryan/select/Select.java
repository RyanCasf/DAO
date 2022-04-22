package br.com.ryan.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.ryan.connection.JDBC;

public class Select {
	public static void main(String[] args) {
		ResultSet result = JDBC.execute("select * from pes01_pessoa");

		try {
			while (result.next()) {
				System.out.printf("%d: %s\n", result.getInt("chave"), result.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}