package fr.eni.encheres.dal;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;

/**
 * 
 * @author Lydie Allart
 *
 */
public interface EnchereDAO {
	
	public void insert(Enchere enchere, int noUtilisateur, int noArticle) throws BusinessException;
	
}
