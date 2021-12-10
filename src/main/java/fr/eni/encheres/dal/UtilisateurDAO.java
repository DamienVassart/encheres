package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * 
 * @author Laurane Marie
 *
 */
public interface UtilisateurDAO {
	
	// S'inscrire
	public void insert(Utilisateur utilisateur) throws BusinessException;
	
	// Modifier profil
	public void update(Utilisateur utilisateur) throws BusinessException;
	
	// Supprimer profil
	public void  delete(int noUtilisateur) throws BusinessException;
	
	//Se Connecter / Afficher Profil
	public Utilisateur selectById(int noUtilisateur) throws BusinessException;
	
	public List<Utilisateur> selectAll() throws BusinessException;


	
}
