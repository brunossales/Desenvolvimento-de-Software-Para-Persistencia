package br.ufc.quixada.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost/contatos", "postgres", "postgres");
	}
}
