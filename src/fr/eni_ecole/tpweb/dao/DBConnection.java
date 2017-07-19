package fr.eni_ecole.tpweb.dao;
/**
 * @author adelaune2017
 * @date 18 juil. 2017
 * @version DemoServlet V1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * Classe en charge de gérer la connexion à une base de données de type SQL Server.
 * @author adelaune2017
 * @date 18 juil. 2017
 * @version DemoServlet V1.0
 */
public class DBConnection {
	public static Connection getConnection() throws SQLException {
		// Chargement du pilote
		DriverManager.registerDriver(new SQLServerDriver());
		// Défnition de la chaîne de connexion
		String url = "jdbc:sqlserver://localhost:1433;databasename=TPJavaEE_GestionFormations;user=sa;password=Pa$$w0rd";
		// Ouverture de la connexion
		Connection connection = null;
		connection = DriverManager.getConnection(url);
		return connection;
	}
}
