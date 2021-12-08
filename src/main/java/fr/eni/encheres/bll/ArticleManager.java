package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.javaee.suividesrepas.dal.DAOFactory;
import fr.eni.javaee.suividesrepas.dal.RepasDAO;

/**
 * 
 * @author Damien Vassart
 *
 */

public class ArticleManager {
	
	// Si erreur de compilation: ArticleDAO encore non créé
	// ne pas tenter de résoudre le problème et attendre que la personne concernée ait créé le compossant manquant
	private ArticleDAO articleDAO;
	
	// Si erreur de compilation: DAOFactory encore non créé
	// ne pas tenter de résoudre le problème et attendre que la personne concernée ait créé le compossant manquant
	public ArticleManager() {
		super();
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	public void addArticle(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int miseAPrix) throws BusinessException {
		BusinessException ex = new BusinessException();
		Article article = null;
		
		this.validerNom(nomArticle, ex);
		this.validerDescription(description, ex);
		this.validerDateDebut(dateDebut, ex);
		this.validerDateFin(dateFin, ex);
		this.valiserMiseAPrix(miseAPrix, ex);
		
		if(!ex.hasErreurs()) {
			article = new Article();
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebut); 
			article.setDateFinEncheres(dateFin); 
			article.setMiseAPrix(miseAPrix);
			
			this.articleDAO.insert(article); // Le DAOFactory doit retourner une instance de ArticleDAOJDBCImpl
			
		} else {
			throw ex;
		}
	}
	
	public void updateArticle(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int miseAPrix) throws BusinessException {
		BusinessException ex = new BusinessException();
		Article article = null;
		
		this.validerNom(nomArticle, ex);
		this.validerDescription(description, ex);
		this.validerDateDebut(dateDebut, ex);
		this.validerDateFin(dateFin, ex);
		this.valiserMiseAPrix(miseAPrix, ex);
		
		if(!ex.hasErreurs()) {
			article = new Article();
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebut); 
			article.setDateFinEncheres(dateFin); 
			
			this.articleDAO.update(article); // Le DAOFactory doit retourner une instance de ArticleDAOJDBCImpl
			
		} else {
			throw ex;
		}
	}
	
	public void removeArticle(int noArticle) {
		this.articleDAO.delete(noArticle); // Le DAOFactory doit retourner une instance de ArticleDAOJDBCImpl
	}
	
	public List<Article> getArticles() {
		return this.articleDAO.selectAll(); // Le DAOFactory doit retourner une instance de ArticleDAOJDBCImpl
	}
	
	public List<Article> getArticlesByName(String nomArticle) {
		return this.articleDAO.selectByName(nomArticle); // Le DAOFactory doit retourner une instance de ArticleDAOJDBCImpl
	}
	
	public List<Article> getArticlesByCategory(String categorie) {
		return this.articleDAO.selectByCategory(categorie); // Le DAOFactory doit retourner une instance de ArticleDAOJDBCImpl
	}
	
	public Article getArticle(int noArticle) {
		return this.articleDAO.selectById(noArticle); // Le DAOFactory doit retourner une instance de ArticleDAOJDBCImpl
	}
	
	private void validerNom(String nom, BusinessException ex) {
		if(nom == null || nom.trim().equals("") || nom.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_ERREUR); 
	}
	
	private void validerDescription(String description, BusinessException ex) {
		if(description == null || description.trim().equals("") || description.trim().length() > 300)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DESCRIPTION_ERREUR);
	}
	
	private void validerDateDebut(LocalDate dateDebut, BusinessException ex) {
		if(dateDebut.isAfter(LocalDate.now()))
			ex.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_DEBUT_ERREUR);
	}
	
	private void validerDateFin(LocalDate dateFin, BusinessException ex) {
		if(dateFin.isAfter(LocalDate.now()))
			ex.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_FIN_ERREUR);
	}
	
	private void valiserMiseAPrix(int prix, BusinessException ex) {
		if(prix == null || prix == 0)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_PRIX_ERREUR);
	}
}
