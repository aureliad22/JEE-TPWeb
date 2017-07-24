package fr.eni_ecole.tpweb.dao;
/**
 * @author adelaune2017
 * @date 18 juil. 2017
 * @version DemoServlet V1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * Classe en charge de gérer la connexion à une base de données de type SQL Server.
 * @author adelaune2017
 * @date 18 juil. 2017
 * @version DemoServlet V1.0
 */
public class DBConnection {
	/*public static Connection getConnection() throws SQLException {
		// Chargement du pilote
		DriverManager.registerDriver(new SQLServerDriver());
		// Défnition de la chaîne de connexion
		String url = "jdbc:sqlserver://localhost:1433;databasename=TPJavaEE_GestionFormations;user=sa;password=Pa$$w0rd";
		// Ouverture de la connexion
		Connection connection = null;
		connection = DriverManager.getConnection(url);
		return connection;
	}*/
	
	public static Connection getConnection() throws SQLException {
		InitialContext jndi = null;
		DataSource ds = null;
		// ----> Obtenir une référence sur le contexte initial JNDI
		try {
			jndi = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		// ----> recherche de la source de données
		try {
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/datasource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		// ----> obtenir une connexion
		return ds.getConnection();
	}
}
