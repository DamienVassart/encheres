package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;


/**
 * 
 * @author Damien Vassart
 *
 */

public class UtilisateurDAOJDBCImpl implements UtilisateurDAO {
	
	/**
	 * Requêtes SQL
	 */
	private static final String SQL_INSERT = "INSERT INTO Utilisateurs"
											+ " (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
											+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE = "UPDATE Utilisateurs SET"
											+ "pseudo = ?, nom = ?, prenom = ?, "
											+ "email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, "
											+ "mot_de_passe = ?, credit = ?, administrateur = ?"
											+ "WHERE no_utilisateur = ?;";
	private static final String SQL_DELETE = "DELETE FROM Utilisateurs WHERE no_utilisateur = ?;";
	private static final String SQL_SELECT_ALL = "SELECT (no_utilisateur, pseudo, nom, prenom, "
												+ "email, telephone, rue, code_postal, ville, "
												+ "mot_de_passe, credit, administrateur)"
												+ "FROM Utilisateurs;";
	private static final String SQL_SELECT_BY_ID = "SELECT (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)"
												+ "FROM Utilisateurs WHERE no_utilisateur = ?;";
	
	/*
	 * Insertion d'un nouvel utilisateur (Inscription)
	 */
	public void insert(Utilisateur utilisateur) throws BusinessException {
		if(utilisateur == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_NULL);
			throw businessException;
		}
		
		try (Connection cn = ConnectionProvider.getConnection()) {
			
			try {
				PreparedStatement ps = cn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, utilisateur.getPseudo());
				ps.setString(2, utilisateur.getNom());
				ps.setString(3, utilisateur.getPrenom());
				ps.setString(4, utilisateur.getEmail());
				ps.setString(5, utilisateur.getTelephone());
				ps.setString(6, utilisateur.getRue());
				ps.setString(7, utilisateur.getCodePostal());
				ps.setString(8, utilisateur.getVille());
				ps.setString(9, utilisateur.getMotDePasse());
				ps.setInt(10, utilisateur.getCredit());
				ps.setBoolean(11, utilisateur.isAdministrateur());
				
				ps.executeUpdate();
				
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next())
					utilisateur.setNoUtilisateur(rs.getInt(1));
				
				rs.close();
				ps.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_ECHEC);
			throw businessException;
		}
	}
	
	/*
	 * Mise à jour d'un utilisateur existant (Modifier mon profil)
	 */
	public void update(Utilisateur utilisateur) throws BusinessException {
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRue());
			ps.setString(7, utilisateur.getCodePostal());
			ps.setString(8, utilisateur.getVille());
			ps.setString(9, utilisateur.getMotDePasse());
			ps.setInt(10, utilisateur.getCredit());
			ps.setBoolean(11, utilisateur.isAdministrateur());
			ps.setInt(12, utilisateur.getNoUtilisateur());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_UTILISATEUR_ECHEC);
			throw businessException;
		}
	}
	
	/*
	 * Suppression d'un utilisateur (Supprimer mon profil)
	 */
	public void delete(int noUtilisateur) throws BusinessException {
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_DELETE);
			ps.setInt(1, noUtilisateur);
			ps.executeUpdate();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_UTILISATEUR_ECHEC);
			throw businessException;
		}
	}
	
	/*
	 * Sélectionner tous les utilisateurs
	 */
	public List<Utilisateur> selectAll() throws BusinessException {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			Utilisateur utilisateur = new Utilisateur();
			while(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				
				listeUtilisateurs.add(utilisateur);
			}
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEUR_ECHEC);
			throw businessException;
		}
		
		return listeUtilisateurs;
	}
	
	/*
	 * Sélection d'un utilisateur (Afficher un profil, Se Connecter)
	 */
	public Utilisateur selectById(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_ID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEUR_ECHEC);
			throw businessException;
		}
		return utilisateur;
	}
}
