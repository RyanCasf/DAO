package br.com.ryan.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC 
{
	public static ResultSet execute(String sql) 
	{
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection = 
            	DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/dao","root", "");
            
            Statement statement = connection.createStatement();
			statement.executeQuery(sql.toString());
            ResultSet set = statement.getResultSet();

            return set;
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
	}
}