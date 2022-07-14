package br.com.ryan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC implements ConnectionInterface {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String LOCAL = "jdbc:mysql://localhost:3306/dao";
	private static final String USER = "root";
	private static final String PASSWD = "";
	
	public ResultSet execute(String sql) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(LOCAL,USER,PASSWD);

			statement = connection.createStatement();
			statement.executeQuery(sql);
			
			return statement.getResultSet();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			finalizacao(connection, statement);
		}
		
		return null;
	}
	
	public void finalizacao(Connection connection, Statement statement) {
		try {
			if (connection != null) {
				connection.close();
			}
			
			if (statement != null) {
				statement.close();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}