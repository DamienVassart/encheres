package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.DALException;
/**
 * 
 * @author Lydie Allart
 *
 */

public interface ArticleDAO {
	
	//Sélectionner un article par son idArticle
	public Article selectById(int idArticle) throws DALException;
	
	//Sélectionner tous les articles 
	public List<Article> selectAll() throws DALException;
	
	//Sélectionner les articles par nom
	public List<Article> selectByName(int nom) throws DALException;
		
	//Sélectionner les articles par la catégorie
	public List<Article> selectByCategorie(String categorie) throws DALException;
	
	//Modifier les attributs d'un article connu en BD
	public void update(Article article) throws DALException;
			
	//Insérer un nouvel article
	public void insert(Article article) throws DALException;
	
	//Supprimer un article
	public void delete(int noArticle) throws DALException;
	
}
