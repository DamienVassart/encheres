package fr.eni.encheres.dal;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList; 

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Retrait;

/**
 * 
 * @author Dorothée Blanchard
 * @param <getLocalDate>
 *
 */

public class ArticleDAOJDBCImpl<getLocalDate> implements ArticleDAO {
	/*
	 *  SQL requests
	 */
	// Insert dans la table Articles
	// note DB: pas besoin d'insérer no_article, c'est une clé primaire autogénérée
	private static final String SQL_INSERT_ARTICLE = "INSERT INTO Articles_Vendus" 
			+ " (nom_article, description, date_debut_encheres, date_fin_encheres, "
			+ " prix_initial, prix_vente, no_utilisateur, no_categorie) "
			+ "Values (?, ?, ?, ?, ?, ?, ?, ?);";
	
	// Insert dans la table Retraits
	private static final String SQL_INSERT_RETRAIT = "INSERT INTO Retraits"
			+ " (no_article, rue, code_postal, ville) "
			+ "Values (?, ?, ?, ?);"; 
		
	
	// update dans la table Articles
	private static final String SQL_UPDATE_ARTICLE = "UPDATE Articles_Vendus SET"
			+ "nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?,"
			+ "prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ?"
			+ "WHERE no_article = ?"; 

	
	// update dans la table Retraits
	private static final String SQL_UPDATE_RETRAIT = "UPDATE Retraits SET"
			+ "rue = ?, code_postal = ?, ville = ?"
			+ "WHERE no_article = ?"; 
	
	// delete dans la table Articles
	private static final String SQL_DELETE_ARTICLE = "DELETE FROM Articles_Vendus WHERE no_article = ?"; 
	
	// delete dans la table Retraits
	private static final String SQL_DELETE_RETRAIT = "DELETE FROM Retraits WHERE no_article = ?"; 
	
	// delete dans la table Encheres
	private static final String SQL_DELETE_ENCHERE = "DELETE FROM Encheres WHERE no_article = ?";
	
	// select sur toute la table Articles
	private static final String SQL_SELECT_ALL_ARTICLES = "SELECT (no_article, nom_article, description, date_debut_encheres, "
			+ "date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ "FROM Articles_Vendus;";
	
	// select par nom sur la table Articles
	private static final String SQL_SELECT_BY_NAME_ARTICLES = "SELECT (no_article, nom_article, description, date_debut_encheres,"
			+ "date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ "FROM Articles_Vendus WHERE nom_article LIKE '%?%';";
	
	// select par catégorie sur la table Articles
	private static final String SQL_SELECT_BY_CAT_ARTICLE = "SELECT (no_categorie, libelle)"
			+ "FROM Articles_Vendus;"
			+ "INNER JOIN Articles_Vendus.no_categorie = Categories.no_categorie"; // le join est-il correct? 
	
	// select par id (no_article) sur la table Articles
	private static final String SQL_SELECT_BY_ID_ARTICLE = "SELECT (no_article, nom_article, description, date_debut_encheres,"
			+ "date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) "
			+ "FROM Articles_Vendus WHERE no_article = ?;"
			+ "NATURAL JOIN Articles_Vendus.no_article = Retraits.no_article"; // le join est-il correct? 
	
	// select par id (no_article) sur la table Retraits
	private static final String SQL_SELECT_RETRAIT_BY_ARTICLE = "SELECT (no_article, rue, code_postal, ville) "
			+ "FROM Retraits WHERE no_article = ?;";
	
	// select par id (no_article) sur la table Encheres
	private static final String SQL_SELECT_ENCHERE_BY_ARTICLE = "SELECT (date_enchere, montant_enchere)"
			+ "FROM Encheres WHERE no_article = ?;";
	
	// select par id (no_utilisateur) sur la table Encheres
	private static final String SQL_SELECT_ENCHERES_BY_USER = "SELECT (date_enchere, montant_enchere) "
			+ "FROM Encheres WHERE no_utilisateur = ?;";
	
	/*
	 * Implémenter les méthodes d'ArticleDAO
	 */

	//Sélectionner un article par son noArticle
	public Article selectById(int noArticle) throws BusinessException {
		Article article = new Article();
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_ID_ARTICLE);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				article.setNoArticle(rs.getInt("noArticle"));
				// faire la meme chose avec les autres trucs de l'article
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres((rs.getDate("date_debut_encheres")));
				article.setDateFinEncheres((rs.getDate("date_fin_encheres")));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setEstVendu(rs.getBoolean("est_vendu"));
			}
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace(); //ne pas oublier de le mettre
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLE_ECHEC);
			throw businessException;
		} return article;
	}

	//Sélectionner tous les articles
	public List<Article> selectAll() throws BusinessException {
		List<Article> listeArticles = new ArrayList<>(); 
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_ALL_ARTICLES);
			ResultSet rs = ps.executeQuery(); 
			Article article = new Article(); 
			while(rs.next() ) {
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				article.setDateFinEncheres((rs.getDate("date_fin_encheres")));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setEstVendu(rs.getBoolean("est_vendu"));
				
				listeArticles.add(article);
			}
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace(); //ne pas oublier de le mettre
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_LISTE_ARTICLES_ECHEC);
			throw businessException;
		} return listeArticles;
		
	}
	
	//Sélectionner les articles par nom
	public List<Article> selectByName(String nom) throws BusinessException {
		List<Article> listeArticles = new ArrayList<>(); 
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_NAME_ARTICLES);
			ResultSet rs = ps.executeQuery(); 
			Article article = new Article(); 
			while(rs.next() ) {
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres((rs.getDate("date_debut_encheres")));
				article.setDateFinEncheres((rs.getDate("date_fin_encheres")));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setEstVendu(rs.getBoolean("est_vendu"));
				
				listeArticles.add(article);
			}
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace(); //ne pas oublier de le mettre
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_LISTE_ARTICLES_ECHEC);
			throw businessException;
		} return listeArticles;
	}
	
	//Sélectionner les articles par la catégorie
	public List<Article> selectByCategory(String categorie) throws BusinessException {
		List<Article> listeArticles = new ArrayList<>(); 
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_CAT_ARTICLE);
			ResultSet rs = ps.executeQuery(); 
			Article article = new Article(); 
			while(rs.next() ) {
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres((rs.getDate("date_debut_encheres")));
				article.setDateFinEncheres((rs.getDate("date_fin_encheres")));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setEstVendu(rs.getBoolean("est_vendu"));
				
				listeArticles.add(article);
			}
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace(); //ne pas oublier de le mettre
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLE_ECHEC);
			throw businessException;
		} return listeArticles;
	}
	
	//Modifier les attributs d'un article connu en base de données
	public void update(Article article, Retrait retrait) throws BusinessException {
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_UPDATE_ARTICLE);
			
			ps.setInt(1, article.getNoArticle());
			ps.setString(2, article.getNomArticle());
			ps.setString(3, article.getDescription());
			ps.setDate(4, article.getDateDebutEncheres());
			ps.setDate(5, article.getDateFinEncheres());
			ps.setInt(6, article.getMiseAPrix());
			ps.setInt(7, article.getPrixVente());
			ps.setBoolean(8, article.getEstVendu());
			
			ps.executeUpdate();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ARTICLE_ECHEC);
			throw businessException;

		}
		
	}

	//Insérer un nouvel article
	public void insert(Article article, Retrait retrait) throws BusinessException {
		if(article == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_NULL);
			throw businessException;
		}
		
		try (Connection cn = ConnectionProvider.getConnection()){
			
			try {
				PreparedStatement ps = cn.prepareStatement(SQL_INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS); 
				
				ps.setInt(1, article.getNoArticle());
				ps.setString(2, article.getNomArticle());
				ps.setString(3, article.getDescription());
				ps.setDate(4, article.getDateDebutEncheres());
				ps.setDate(5, article.getDateFinEncheres());
				ps.setInt(6, article.getMiseAPrix());
				ps.setInt(7, article.getPrixVente());
				ps.setBoolean(8, article.getEstVendu());
				
				ps.executeUpdate(); 
				
				ResultSet rs = ps.getGeneratedKeys(); 
				if(rs.next())
					article.setNoArticle(rs.getInt(1));
				
				rs.close();
				ps.close();
				
				
			} catch (Exception ex) {
				throw ex;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC );
			throw businessException;

		}

		
	}

	//Supprimer un article
	public void delete(int noArticle) throws BusinessException {
		try (Connection cn = ConnectionProvider.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_DELETE_ARTICLE);
			ps.setInt(1, noArticle);
			ps.executeUpdate();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_ARTICLE_ECHEC);
			throw businessException;

		}
		
		
	}
	
}

