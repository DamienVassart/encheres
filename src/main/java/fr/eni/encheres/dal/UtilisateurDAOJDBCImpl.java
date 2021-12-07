package fr.eni.encheres.dal;

import java.util.ArrayList;
import java.util.List;

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
	private static final String SQL_INSERT = "";
	private static final String SQL_UPDATE = "";
	private static final String SQL_DELETE = "";
	private static final String SQL_SELECT_ALL = "";
	private static final String SQL_SELECT_BY_ID = "";
	
	/*
	 * Insertion d'un nouvel utilisateur (Inscription)
	 */
	public void insert(Utilisateur utilisateur) {
		// TODO
	}
	
	/*
	 * Mise à jour d'un utilisateur existant (Modifier mon profil)
	 */
	public void update(Utilisateur utilisateur) {
		// TODO
	}
	
	/*
	 * Suppression d'un utilisateur (Supprimer mon profil)
	 */
	public void delete(int noUtilisateur) {
		// TODO
	}
	
	/*
	 * Sélectionner tous les utilisateurs
	 */
	public List<Utilisateur> selectAll() {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		// TODO
		return listeUtilisateurs;
	}
	
	/*
	 * Sélection d'un utilisateur (Afficher un profil, Se Connecter)
	 */
	public Utilisateur selectById(int noUtilisateur) {
		Utilisateur utilisateur = null;
		// TODO
		return utilisateur;
	}
}
