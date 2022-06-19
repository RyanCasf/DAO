package br.com.ryan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC implements ConnectionInterface {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String LOCAL = "jdbc:mysql://localhost:3306/dao";
	private static final String USER = "root";
	private static final String PASSWD = "";
	
	public ResultSet execute(String sql) {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(
					LOCAL,
					USER, 
					PASSWD
			);

			Statement statement = connection.createStatement();
			statement.executeQuery(sql);
			ResultSet set = statement.getResultSet();

//			connection.close();
//			set.close();
			return set;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erro: " + e.getMessage());
		}
		
		return null;
	}
}