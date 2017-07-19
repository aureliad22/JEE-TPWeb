/**
 * @author adelaune2017
 * @date 19 juil. 2017
 * @version TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni_ecole.tpweb.tools.ManipDate;
import fr.eni_ecole.tpweb.bo.Formation;

/**
 * Classe en charge de gérer la couche d'accès à la BdD pour les objets de type
 * Formation.
 * 
 * @author adelaune2017
 * @date 19 juil. 2017
 * @version TPWeb V1.0
 */
public class DAOFormation implements DAOBase<Formation> {

	private static final String RQ_INSERT = "INSERT INTO formations(libelle, description, debut, fin) VALUES(?,?,?,?);";
	private static final String RQ_ALL = "SELECT * FROM formations;";

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.DAOBase#update(java.lang.Object)
	 */
	@Override
	public void update(Formation formation) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.DAOBase#insert(java.lang.Object)
	 */
	@Override
	public void insert(Formation formation) throws Exception {
		PreparedStatement cmd = null;
		try {
			Connection cnx = DBConnection.getConnection();
			cmd = cnx.prepareStatement(RQ_INSERT,
					Statement.RETURN_GENERATED_KEYS);
			cmd.setString(1, formation.getLibelle());
			cmd.setString(2, formation.getDescription());
			cmd.setDate(3, ManipDate.dateUtilVersSQL(formation.getDateDebut()));
			cmd.setDate(4, ManipDate.dateUtilVersSQL(formation.getDateFin()));
			cmd.executeUpdate();

			ResultSet rs = cmd.getGeneratedKeys();
			if (rs.next()) {
				formation.setId(rs.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'insertion du message dans la base TPJavaEE_GestionFormations!");
		} finally {
			cmd.getConnection().close();
			cmd = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.DAOBase#delete(java.lang.Object)
	 */
	@Override
	public void delete(Formation formation) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.DAOBase#selectById(java.lang.Object)
	 */
	@Override
	public <Type> Formation selectById(Type id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * Méthode héritée en charge de retourner l'ensemble des formations
	 * à partir de la BdD.
	 * @see fr.eni_ecole.tpweb.dao.DAOBase#selectAll()
	 */
	@Override
	public List<Formation> selectAll() throws Exception {
		List<Formation> listeFormations = new ArrayList<Formation>();
		try (Connection cnx = DBConnection.getConnection()) {
			PreparedStatement cmd = cnx.prepareStatement(RQ_ALL);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				Formation f = itemBuilder(rs);
				listeFormations.add(f);
				System.out.println(f.getLibelle());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'affichage des formations à partir de la base TPJavaEE_GestionFormations!");
		}
		return listeFormations;
	}

	/**
	 * Méthode en charge de construire un objet de type Formation 
	 * à partir des données de la BdD 
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private Formation itemBuilder(ResultSet rs) throws SQLException {
		Formation formation  = new Formation();
		formation.setId(rs.getInt("id"));
		formation.setLibelle(rs.getString("libelle"));
		formation.setDescription(rs.getString("description"));
		formation.setDateDebut(ManipDate.dateSQLVersUtil(rs.getDate("debut")));
		formation.setDateFin(ManipDate.dateSQLVersUtil(rs.getDate("fin")));

		return formation;
	}
}
