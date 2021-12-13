/**
 * @author Damien Vassart
 */

package fr.eni.encheres.bll;

import java.sql.Date;
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
	public void addEnchere(int noUtilisateur, int noArticle ,Date dateEnchere, int prixVente, int montantEnchere) throws BusinessException {
		BusinessException ex = new BusinessException();
		Enchere enchere = null;
		
		validerEnchere(prixVente, montantEnchere, ex);
		
		if(!ex.hasErreurs()) {
			enchere = new Enchere();
			enchere.setNoUtilisateur(noUtilisateur);
			enchere.setNoArticle(noArticle);
			enchere.setDateEnchere(dateEnchere);
			enchere.setMontantEnchere(montantEnchere);
			
			this.enchereDAO.insert(enchere);
		} else {
			throw ex;
		}
	}
	
	public List<Enchere> getAllEncheres() throws BusinessException {
		return this.enchereDAO.selectAll();
	}
	
	public Enchere getEnchere(int noUtilisateur, int noArticle) throws BusinessException {
		return this.enchereDAO.selectById(noUtilisateur, noArticle);
	}
	
	public List<Enchere> getEnchereByNoArticle(int noArticle) throws BusinessException {
		return this.enchereDAO.selectByNoArticle(noArticle);
	}
	
	public List<Enchere> getEncheresByNoUtilisateur(int noUtilisateur) throws BusinessException {
		return this.enchereDAO.selectByNoUtilisateur(noUtilisateur);
	}
	
	public void validerEnchere(int prixVente, Integer montantEnchere, BusinessException ex) throws BusinessException {
		if(montantEnchere == null)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_PRIX_NULL);
		if(montantEnchere <= prixVente)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_PRIX_ERREUR); 
	}
}
