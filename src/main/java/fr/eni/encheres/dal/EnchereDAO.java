package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;

/**
 * 
 * @author Lydie Allart
 *
 */
public interface EnchereDAO {
	
	//Faire une nouvelle enchère
	public void insert(Enchere enchere, Article article, int noUtilisateur, int noArticle) throws BusinessException;
	
	//Sélectionner une enchère par son noUtilisateur, noArticle
	public Enchere selectById(int noUtilisateur, int noArticle) throws BusinessException;
	
	//Sélectionner la liste de toutes les enchères
	public List<Enchere> selectAll() throws BusinessException;
		
	//Sélectionner la liste des enchères par noUtilisateur
	public List<Enchere> selectByNoUtilisateur(int noUtilisateur) throws BusinessException;
			
	//Sélectionner la liste des enchères par noArticle
	public List<Enchere> selectByNoArticle(int noArticle) throws BusinessException;
	
}