package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {
	
	public List<Article> selectArticle();
	
	
	
	
	public Article insert(Article article);
	
	public Article select(int idArticle);
}
