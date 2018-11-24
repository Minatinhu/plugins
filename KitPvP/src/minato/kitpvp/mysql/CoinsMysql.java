package minato.kitpvp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import minato.kitpvp.main.Main;

public class CoinsMysql {
	
	private Connection con;
	
	public void abrirConexão() {
		String user = Main.cf.getString("Coins.Mysql.User");
		String password = Main.cf.getString("Coins.Mysql.Password");
		String host = Main.cf.getString("Coins.Mysql.Host");
		int port = Main.cf.getInt("Coins.Mysql.Port");
		String datebase = Main.cf.getString("Coins.Mysql.DateBase");
		String type = "jdbc:mysql://";
		String url = type + host + ":" + port + "/" + datebase;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
