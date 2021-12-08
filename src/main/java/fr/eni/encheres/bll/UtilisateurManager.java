package fr.eni.encheres.bll;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * 
 * @author Lydie Allart
 *
 */
public class UtilisateurManager {
	
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	private UtilisateurDAO utilisateurDAO;
	

//Méthodes appelant celles de la DAL
	
	//SInscrire
	public void addUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue,
			int codePostal, String ville, String motDePasse) {
		utilisateurDAO.addUtilisateur(utilisateurDAO);
	}
	//AUTRE A VOIR :
	//	public void createUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue,
	//			int codePostal, String ville, String motDePasse) {
	//		utilisateurDAO.createUtilisateur(utilisateurDAO);
	//	}
	
	//ModifierMonProfil
	public void udpdateUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue, 
			int codePostal, String ville, String motDePasse) throws SQLException {
		utilisateurDAO.updateUtilisateur(utilisateurDAO);
	}
	
	//SupprimerMonCompte
	public void removeUtilisateur (int noUtilisateur) {
		utilisateurDAO.removeUtilisateur(utilisateurDAO);
	}
	//AUTRE A VOIR :
	//	public void deleteUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue, 
	//			int codePostal, String ville, String motDePasse) {
	//		utilisateurDAO.delete(utilisateurDAO);
	//	}
	
//SeConnecter #AfficherUnProfil
	//SeConnecter:
	public Utilisateur seConnecter(String login, String motDePasse) throws SQLException {
		return utilisateurDAO.selectUtilisateurConnection(login, motDePasse);
	}	
	//AfficherUnProfil
	public Utilisateur getUtilisateur(int noUtilisateur) {
		return UtilisateurDAO();
	}

}

