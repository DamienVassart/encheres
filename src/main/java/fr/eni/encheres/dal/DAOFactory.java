package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Article;

/**
 * 
 * @author Laurane Marie
 *
 */

public class DAOFactory implements ArticleDAO {

	public static selectById(int noArticle) {
		return null;
	}

	@Override
	public List<Article> selectAll() {
		return null;
	}

	public static ArticleDAO getArticleDAO() {
		return null;

	}

	@Override
	public List<Article> selectByName(String nom) {
		return null;
	}

	@Override
	public List<Article> selectByCategory(String categorie) {
		return null;
	}

	@Override
	public void update(Article article) {

	}

	@Override
	public void delete(int noArticle) {

	}

	@Override
	public List<Article> selectArticle() {
		return null;
	}

	@Override
	public Article insert(Article article) {
		return null;
	}

	@Override
	public Article select(int idArticle) {
		return null;
	}

}
