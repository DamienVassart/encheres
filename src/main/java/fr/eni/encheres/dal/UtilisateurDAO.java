package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

/**
 * 
 * @author Laurane Marie
 *
 */
public interface UtilisateurDAO {
	
	// S'inscrire
	public void insert(Utilisateur utilisateur);
	
	// Modifier profil
	public void update(Utilisateur utilisateur);
	
	// Supprimer profil
	public void  delete(int noUtilisateur);
	
	//Se Connecter / Afficher Profil
	public Utilisateur selectById(int noUtilisateur);
	
	public List<Utilisateur> selectAll();

}
