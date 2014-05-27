package br.com.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * classe que faz a coexão com o banco de dados
 * @author Ramon
 *
 */

public class ConnectionFactory {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/pswcefet", "lucasrodriguex", "mn210794");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
