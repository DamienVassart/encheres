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
	private static final String SQL_INSERT_ARTICLE = "INSERT INTO Articles" 
			+ " (no_article, nom_article, description, date_debut_encheres, date_fin_encheres, "
			+ " prix_initial, prix_vente, no_utilisateur, no_categorie) "
			+ "Values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	// Insert dans la table Retraits
	private static final String SQL_INSERT_RETRAIT = "INSERT INTO Retraits"
			+ " (no_article, rue, code_postal, ville) "
			+ "Values (?, ?, ?, ?);"; 
		
	
	// update dans la table Articles
	private static final String SQL_UPDATE_ARTICLE = "UPDATE Articles"
			+ " (no_article, nom_article, description, date_debut_encheres, date_fin_encheres, "
			+ " prix_initial, prix_vente, no_utilisateur, no_categorie) "
			+ "Values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	// update dans la table Retraits
	private static final String SQL_UPDATE_RETRAIT = "UPDATE Retraits"
			+ " (no_article, rue, code_postal, ville) "
			+ "Values (?, ?, ?, ?);"; 
	
	// delete dans la table Articles
	private static final String SQL_DELETE_ARTICLE = "DELETE FROM Articles" 
			+ " (no_article, nom_article, description, date_debut_encheres, date_fin_encheres, "
			+ " prix_initial, prix_vente, no_utilisateur, no_categorie) "
			+ "Values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	// delete dans la table Retraits
	private static final String SQL_DELETE_RETRAIT = "DELETE FROM Retraits" 
			+ " (no_article, rue, code_postal, ville) "
			+ "Values (?, ?, ?, ?);"; 
	
	// delete dans la table Encheres
	private static final String SQL_DELETE_ENCHERE = "DELETE FROM Encheres" 
			+ " (no_utilisateur, no_article, date_enchere, montant_enchere) "
			+ "Values ();";
	
	// select sur toute la table Articles
	private static final String SQL_SELECT_ALL_ARTICLES = "SELECT (no_article, nom_article, description, date_debut_encheres, date_fin_encheres, "
			+ " prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ "FROM Articles;";
	
	// select par nom sur la table Articles
	private static final String SQL_SELECT_BY_NAME_ARTICLES = "SELECT (nom_article)"
			+ "FROM Articles;";
	
	// select par catégorie sur la table Articles
	private static final String SQL_SELECT_BY_CAT_ARTICLE = "SELECT (no_categorie, libelle)"
			+ "FROM Articles;";
	
	// select par id (no_article) sur la table Articles
	private static final String SQL_SELECT_BY_ID_ARTICLE = "SELECT (no_article)"
			+ "FROM Articles;";
	
	// select par id (no_article) sur la table Retraits
	private static final String SQL_SELECT_RETRAIT_BY_ARTICLE = "SELECT (no_article)"
			+ "FROM Retraits;";
	
	// select par id (no_article) sur la table Encheres
	private static final String SQL_SELECT_ENCHERE_BY_ARTICLEN = "SELECT (no_article)"
			+ "FROM Encheres;";
	
	// select par id (no_utilisateur) sur la table Encheres
	private static final String SSQL_SELECT_ENCHERES_BY_USER = "SELECT (no_utilisateur)"
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
}

