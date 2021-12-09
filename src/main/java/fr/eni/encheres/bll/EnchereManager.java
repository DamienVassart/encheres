/**
 * @author Damien Vassart
 */

package fr.eni.encheres.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereManager {
	private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		super();
		this.enchereDAO = DAOFactory.getEnchereDAO();
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
	 * TODO: compléter EnchereDAO (@Lydie)
	 */
	public List<Enchere> getEnchereByNoArticle(int noArticle) throws BusinessException {
		return this.enchereDAO.selectByArticle(noArticle);
	}
	
	public List<Enchere> getEnchereByNoUtilisateur(int noUtilisateur) throws BusinessException {
		return this.enchereDAO.selectByUser(noUtilisateur);
	}
	
	public void removeEnchere(int noArticle) throws BusinessException {
		this.enchereDAO.delete(noArticle);
	}
	
	public void validerPrix(int prixVente, Integer montantEnchere, BusinessException ex) throws BusinessException {
		if(montantEnchere == null)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_PRIX_NULL);
		if(montantEnchere <= prixVente)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_PRIX_ERREUR);
	}
}
