package fr.eni.encheres.dal;

public abstract class CodesResultatDAL {
	/*
	 * Echec lors de la tentative d'insertion d'un utilisateur NULL
	 */
	public static final int INSERT_UTILISATEUR_NULL = 10000;
	
	/*
	 * Echec lors de la tentative d'insertion d'un utilisateur
	 */
	public static final int INSERT_UTILISATEUR_ECHEC = 10001;
	
	/*
	 * Echec lors de la tentative de modification d'un utilisateur
	 */
	public static final int UPDATE_UTILISATEUR_ECHEC = 10002;
	
	/*
	 * Echec lors de la tentative de suppression d'un utilisateur
	 */
	public static final int DELETE_UTILISATEUR_ECHEC = 10003;
	
	/*
	 * Echec lors de la récupération d'un utilisateur
	 */
	public static final int SELECT_UTILISATEUR_ECHEC = 10004;
	
	/*
	 * Echec lors de la tentative d'insertion d'un article NULL
	 */
	public static final int INSERT_ARTICLE_NULL = 10005;
	
	/*
	 * Echec lors de la tentative d'insertion d'un article
	 */
	public static final int INSERT_ARTICLE_ECHEC = 10006;
	
	/*
	 * Echec lors de la tentative de modification d'un article
	 */
	public static final int UPDATE_ARTICLE_ECHEC = 10007;
	
	/*
	 * Echec lors de la tentative de suppression d'un article
	 */
	public static final int DELETE_ARTICLE_ECHEC = 10008;
	
	/*
	 * Echec lors de la récupération d'une liste d'articles
	 */
	public static final int SELECT_LISTE_ARTICLES_ECHEC = 10009;
	
	/*
	 * Echec lors de la récupération d'un article
	 */
	public static final int SELECT_ARTICLE_ECHEC = 10010;
}
