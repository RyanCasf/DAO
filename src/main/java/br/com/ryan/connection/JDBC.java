package br.com.ryan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	private JDBC() {
		throw new IllegalStateException("Classe exclusivamente utilitária!");
	}

	public static ResultSet execute(String sql) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dao", "root", "");

			Statement statement = connection.createStatement();
			statement.executeQuery(sql);
			ResultSet set = statement.getResultSet();

			connection.close();
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}
}