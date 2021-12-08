package fr.eni.encheres.dal;

import java.util.List;
import java.lang.reflect.*;

import fr.eni.encheres.bo.Article;

/**
 * 
 * @author Laurane Marie
 *
 */

public class DAOFactory implements ArticleDAO {



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

	@Override
	public void add(Article article) {
		
	}

	@Override
	public Article selectById(int noArticle) {
		return null;
	}
	private Class ArticleManager;
	private String articleManager;
	
	public DAOFactory(String articleManager) {
		this.setArticleManager(articleManager);
		try {
			setArticleManager(Class.forName(articleManager));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Class getArticleManager() {
		return ArticleManager;
	}

	public void setArticleManager(Class articleManager) {
		ArticleManager = articleManager;
	}

	public void setArticleManager(String articleManager) {
		this.articleManager = articleManager;
	}

}
