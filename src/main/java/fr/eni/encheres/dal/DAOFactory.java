package fr.eni.encheres.dal;

/**
 * 
 * @author Laurane Marie
 *
 */

public class DAOFactory {

	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJDBCImpl();
	}

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJDBCImpl();
	}

	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJDBCImpl();
	}

}