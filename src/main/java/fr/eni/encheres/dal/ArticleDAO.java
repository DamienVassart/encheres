package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.BusinessException;
/**
 * 
 * @author Lydie Allart
 *
 */

public interface ArticleDAO {
	
	//Sélectionner un article par son noArticle
	public Article selectById(int noArticle) throws BusinessException;
	
	//Sélectionner tous les articles 
	public List<Article> selectAll() throws BusinessException;
	
	//Sélectionner les articles par nom
	public List<Article> selectByName(String nom) throws BusinessException;
		
	//Sélectionner les articles par la catégorie
	public List<Article> selectByCategory(String categorie) throws BusinessException;
	
	//Modifier les attributs d'un article connu en BD
	public void update(Article article, Retrait retrait) throws BusinessException;
			
	//Insérer un nouvel article
	public void insert(Article article, Retrait retrait) throws BusinessException;
	
	//Supprimer un article
	public void delete(int noArticle) throws BusinessException;
	
}
