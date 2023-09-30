package br.com.ryan.connection;

import java.sql.ResultSet;

public interface ConnectionInterface {
	public ResultSet execute(String sql);
}