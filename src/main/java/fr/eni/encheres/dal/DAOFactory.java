package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;


/**
 * 
 * @author Laurane Marie
 *
 */

public class DAOFactory  {
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJDBCImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJDBCImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJDBCImpl();
	}
	
	




}
