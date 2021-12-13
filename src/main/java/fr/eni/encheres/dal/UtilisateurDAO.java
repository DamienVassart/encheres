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
	public static int update(Utilisateur utilisateur) throws BusinessException {
		return 0;
	}

	// Supprimer profil
	public static void delete(String noUtilisateur) throws BusinessException {

	}

	// Se Connecter / Afficher Profil
	public Utilisateur selectById(int noUtilisateur) throws BusinessException;

	public Utilisateur selectByName(String nom) throws BusinessException;

	public List<Utilisateur> selectAll() throws BusinessException;

}
