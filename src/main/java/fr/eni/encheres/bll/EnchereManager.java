/**
 * @author Damien Vassart
 */

package fr.eni.encheres.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;

public class EnchereManager {
	private EnchereDAO enchereDAO; // TODO: créer EnchereDAO (@Lydie)
	
	public EnchereManager() {
		super();
		this.enchereDAO = DAOFactory.getEnchereDAO(); // TODO: ajouter méthode getEnchereDAO à DAOFactory (@Laurane)
	}
	
	public void addEnchere(int prixVente, int montantEnchere) throws BusinessException {
		BusinessException ex = new BusinessException();
		Enchere enchere = null;
		
		validerPrix(prixVente, montantEnchere, ex);
		
		if(!ex.hasErreurs()) {
			enchere = new Enchere();
			enchere.setDateEnchere(LocalDateTime.now());
			enchere.setMontantEnchere(montantEnchere);
		} else {
			throw ex;
		}
	}
	
	/*
	 * TODO: créer EnchereDAO (@Lydie)
	 */
	public Enchere getEnchereByNoArticle(int noArticle) throws BusinessException {
		return this.enchereDAO.selectByArticle(noArticle);
	}
	
	public List<Enchere> getEnchereByNoUtilisateur(int noUtilisateur) throws BusinessException {
		return this.enchereDAO.selectByUser(noUtilisateur);
	}
	
	public void removeEnchere(int noArticle) throws BusinessException {
		this.enchereDAO.delete(noArticle);
	}
	
	/*
	 * TODO: créer CodesResultatBLL (@Dorothée)
	 */
	public void validerPrix(int prixVente, Integer montantEnchere, BusinessException ex) throws BusinessException {
		if(montantEnchere == null || montantEnchere <= prixVente)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_PRIX);
	}
}
