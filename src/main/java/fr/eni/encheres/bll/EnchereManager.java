/**
 * @author Damien Vassart
 */

package fr.eni.encheres.bll;

import java.time.LocalDateTime;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;

public class EnchereManager {
	private EnchereDAO enchereDAO; // TODO: créer EnchereDAO (@Lydie)
	
	public EnchereManager() {
		super();
		this.enchereDAO = DAOFactory.getEnchereDAO(); // TODO: ajouter méthode getEnchereDAO à DAOFactory (@Laurane)
	}
	
	public void addEnchere(int noUtilisateur, int noArticle, LocalDateTime dateEnchere, int prixVente, int montantEnchere) throws BusinessException {
		// TODO
	}
	
	public Enchere getEnchereByNoArticle(int noArticle) throws BusinessException {
		// TODO
	}
	
	public Enchere getEnchereByNoUtilisateur(int noUtilisateur) throws BusinessException {
		// TODO
	}
	
	public void removeEnchere(int noArticle) throws BusinessException {
		// TODO
	}
	
	/*
	 * TODO: créer CodesResultatBLL (@Dorothée)
	 */
	public void validerPrix(int prixVente, Integer prix, BusinessException ex) throws BusinessException {
		if(prix == null || prix <= prixVente)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_PRIX);
	}
}
