package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.Article;

/**
 * 
 * @author Lydie Allart
 *
 */
public interface ArticleDAO {
	
	//Ajouter l'article
	public void add(Article article);
	public List<Article> selectAll();
	public List<Article> selectByName(String nom);
	public List<Article> selectByCategory(String categorie);
	
	public Article insert(Article article);
	public Article selectById(int noArticle);
	public Article select(int idArticle);
	
	//Modifier l'article
	public void update(Article article);
	
	//Supprimer l'article
	public void delete(int noArticle);
}
