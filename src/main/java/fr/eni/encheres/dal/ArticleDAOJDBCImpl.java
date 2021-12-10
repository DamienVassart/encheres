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
	// note DB: pas besoin d'insérer no_article, c'est une clé primaire autogénérée
	// modifié selon les commentaires github, a verifier
	private static final String SQL_INSERT_ARTICLE = "INSERT INTO Articles" 
			+ " (nom_article, description, date_debut_encheres, date_fin_encheres, "
			+ " prix_initial, prix_vente, no_utilisateur, no_categorie) "
			+ "Values (?, ?, ?, ?, ?, ?, ?, ?);";
	
	// Insert dans la table Retraits
	private static final String SQL_INSERT_RETRAIT = "INSERT INTO Retraits"
			+ " (rue, code_postal, ville) "
			+ "Values (?, ?, ?);"; 
		
	
	// update dans la table Articles
	// modifié selon les commentaires github, a verifier, je ne suis pas sure d'avoir mis les colonnes correctement
	private static final String SQL_UPDATE_ARTICLE = "UPDATE Articles SET"
			+ "nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?,"
			+ "prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ?"
			+ "WHERE no_article = ?"; 

	
	// update dans la table Retraits
	// modifié selon les commentaires github, a verifier, je ne suis pas sure d'avoir mis les colonnes correctement
	private static final String SQL_UPDATE_RETRAIT = "UPDATE Retraits SET"
			+ "rue = ?, code_postal = ?, ville = ?"
			+ "WHERE no_article = ?"; 
	
	// delete dans la table Articles
	// modifié selon les commentaires github, a verifier
	private static final String SQL_DELETE_ARTICLE = "DELETE FROM Articles WHERE no_article = ?"; 
			
	
	// delete dans la table Retraits
	// modifié selon les commentaires github, a verifier
	private static final String SQL_DELETE_RETRAIT = "DELETE FROM Retraits WHERE no_article = ?"; 
	
	// delete dans la table Encheres
	// modifié selon les commentaires github, a verifier
	private static final String SQL_DELETE_ENCHERE = "DELETE FROM Encheres WHERE no_utilisateur = ?";
	
	// select sur toute la table Articles
	private static final String SQL_SELECT_ALL_ARTICLES = "SELECT (no_article, nom_article, description, date_debut_encheres, "
			+ "date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ "FROM Articles;";
	
	// select par nom sur la table Articles
	// modifié selon les commentaires github, a verifier
	private static final String SQL_SELECT_BY_NAME_ARTICLES = "SELECT (no_article, nom_article, description, date_debut_encheres,"
			+ "date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ "WHERE nom_article LIKE '%?%';";
	
	// select par catégorie sur la table Articles
	//  ici la requête comporte une jointure entre les tables Articles_Vendus et Categories. 
	// C'est un peu plus complexe, on en rediscutera en visio
	// private static final String SQL_SELECT_BY_CAT_ARTICLE = "SELECT (no_categorie, libelle)"
	//		+ "FROM Articles;";
	
	// select par id (no_article) sur la table Articles
	// code modifié selon le commentaire github
	// Il y aura de plus une jointure avec la table Retraits à prévoir, mais comme pour la jointure évoquée en 8, on en rediscutera en visio
	private static final String SQL_SELECT_BY_ID_ARTICLE = "SELECT (no_article, nom_article, description, date_debut_encheres,"
			+ "date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) "
			+ "WHERE no_article = ?;";
	
	// select par id (no_article) sur la table Retraits
	// requete modifiée selon le commentaire github
	private static final String SQL_SELECT_RETRAIT_BY_ARTICLE = "SELECT (no_article, rue, code_postal, ville) "
			+ "FROM Retraits WHERE no_article = ?;";
	
	// select par id (no_article) sur la table Encheres
	// requete modifiée selon le commentaire github
	private static final String SQL_SELECT_ENCHERE_BY_ARTICLE = "SELECT (date_enchere, montant_enchere)"
			+ "FROM Encheres WHERE no_article = ?;";
	
	// select par id (no_utilisateur) sur la table Encheres
	// requete modifiée selon le commentaire github
	private static final String SQL_SELECT_ENCHERES_BY_USER = "SELECT (date_enchere, montant_enchere) "
			+ "FROM Encheres WHERE no_utilisateur = ?;";
	
	
	
	
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

