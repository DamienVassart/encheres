package fr.eni.encheres.dal;

import java.util.List;
import java.sql.Connection;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Retrait;

/**
 * 
 * @author Dorothée Blanchard
 *
 */

public class ArticleDAOJDBCImpl implements ArticleDAO {
	// SQL requests
	// Insert dans la table Articles
	private static final String SQL_INSERT = "INSERT INTO Articles" 
			+ " (dateEnchere, montantEnchere) "
			+ "Values (?, ?);";
	
	// Insert dans la table Retraits
	private static final String SQL_INSERT1 = "INSERT INTO Retraits"
			+ " (rue, codePostal, ville) "
			+ "Values (?, ?, ?);"; 
		
	
	// update dans la table Articles
	private static final String SQL_UPDATE = "UPDATE Articles"
			+ " () "
			+ "Values ();";
	
	// update dans la table Retraits
	private static final String SQL_UPDATE1 = "UPDATE Retraits"
			+ " () "
			+ "Values ();";
	
	// delete dans la table Articles
	private static final String SQL_DELETE1 = "DELETE FROM Articles" 
			+ " () "
			+ "Values ();";
	
	// delete dans la table Retraits
	private static final String SQL_DELETE2 = "DELETE FROM Retraits" 
			+ " () "
			+ "Values ();";
	
	// delete dans la table Encheres
	//private static final String SQL_DELETE = "DELETE FROM Encheres" 
	//		+ " () "
	//		+ "Values ();";
	
	// select sur toute la table Articles
	private static final String SQL_SELECT_ALL = "SELECT (noArticle, nomArticle, description, dateDebutEnchere, "
			+ "dateFinEncheres, miseAPrix, prixVente, etatVente)"
			+ "FROM Articles;";
	
	// select par nom sur la table Articles
	private static final String SQL_SELECT_BY_NAME = "SELECT (nomArticles)"
			+ "FROM Articles;";
	
	// select par catégorie sur la table Articles
	private static final String SQL_SELECT_BY_CATEGORY = "SELECT (categorieArticle)"
			+ "FROM Articles;";
	
	// select par id (no_article) sur la table Articles
	private static final String SQL_SELECT_BY_ID = "SELECT (noArticle)"
			+ "FROM Articles;";
	
	// select par id (no_article) sur la table Retraits
	private static final String SQL_SELECT_BY_ID1 = "SELECT (noArticle)"
			+ "FROM Retraits;";
	
	// select par id (no_article) sur la table Encheres
	private static final String SQL_SELECT_BY_ID2 = "SELECT (noArticle)"
			+ "FROM Encheres;";
	
	// select par id (no_utilisateur) sur la table Encheres
	private static final String SQL_SELECT_BY_ID3 = "SELECT (noUtilisateur)"
			+ "FROM Encheres;";
	
	
	
	
	// add implementing methods
	@Override
	public Article selectById(int noArticle) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectByName(String nom) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectByCategory(String categorie) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Article article, Retrait retrait) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Article article, Retrait retrait) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int noArticle) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the sqlInsert
	 */
	public static String getSqlInsert() {
		return SQL_INSERT;
	}

	/**
	 * @return the sqlInsert1
	 */
	public static String getSqlInsert1() {
		return SQL_INSERT1;
	}

	/**
	 * @return the sqlUpdate
	 */
	public static String getSqlUpdate() {
		return SQL_UPDATE;
	}

	/**
	 * @return the sqlUpdate1
	 */
	public static String getSqlUpdate1() {
		return SQL_UPDATE1;
	}

	/**
	 * @return the sqlDelete
	 */
	public static String getSqlDelete() {
		return SQL_DELETE1;
	}

	/**
	 * @return the sqlDelete2
	 */
	public static String getSqlDelete2() {
		return SQL_DELETE2;
	}

	/**
	 * @return the sqlSelectAll
	 */
	public static String getSqlSelectAll() {
		return SQL_SELECT_ALL;
	}

	/**
	 * @return the sqlSelectByName
	 */
	public static String getSqlSelectByName() {
		return SQL_SELECT_BY_NAME;
	}

	/**
	 * @return the sqlSelectByCategory
	 */
	public static String getSqlSelectByCategory() {
		return SQL_SELECT_BY_CATEGORY;
	}

	/**
	 * @return the sqlSelectById
	 */
	public static String getSqlSelectById() {
		return SQL_SELECT_BY_ID;
	}

	/**
	 * @return the sqlSelectById1
	 */
	public static String getSqlSelectById1() {
		return SQL_SELECT_BY_ID1;
	}

	/**
	 * @return the sqlSelectById2
	 */
	public static String getSqlSelectById2() {
		return SQL_SELECT_BY_ID2;
	}

	/**
	 * @return the sqlSelectById3
	 */
	public static String getSqlSelectById3() {
		return SQL_SELECT_BY_ID3;
	}

}
