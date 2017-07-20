/**
 * @author adelaune2017
 * @date 20 juil. 2017
 * @version TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni_ecole.tpweb.bo.Animateur;

/**
 * @author adelaune2017
 * @date 20 juil. 2017
 * @version TPWeb V1.0
 */
public class DAOAnimateur implements IDAOBase<Animateur>{

	private static final String RQ_AUTH_ANIM = "SELECT id, nom, prenom, email, motdepasse "
															+ "FROM animateurs"
															+ "WHERE email = ?"
															+ "AND motdepasse = ?";
	/**
	 * Méthode en charge de retourner l'animateur avec
	 * l'email et le mot de passe fournis
	 * @param email : identifiant à vérifier
	 * @param password : mot de passe à vérifier
	 * @return l'animateur correspondant
	 * @throws SQLException
	 */
	public Animateur getByEmailAndPassword(String email, String password) throws SQLException {
		Animateur result = null;
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_AUTH_ANIM);
			stm.setString(1,  email);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				result = animBuilder(rs);
			}
		}		
		return result;
	}

	/**
	 * Méthode en charge de construire un animateur à partir
	 * des données de la BdD
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private Animateur animBuilder(ResultSet rs) throws SQLException {
		Animateur result = new Animateur();
		result.setId(rs.getInt("id"));
		result.setNom(rs.getString("nom"));
		result.setPrenom(rs.getString("prenom"));
		result.setEmail(rs.getString("email"));
		result.setMotdepasse(rs.getString("motdepasse"));
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#update(java.lang.Object)
	 */
	@Override
	public void update(Animateur data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#insert(java.lang.Object)
	 */
	@Override
	public void insert(Animateur data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#delete(java.lang.Object)
	 */
	@Override
	public void delete(Animateur data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#selectById(java.lang.Object)
	 */
	@Override
	public <Type> Animateur selectById(Type id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#selectAll()
	 */
	@Override
	public List<Animateur> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
