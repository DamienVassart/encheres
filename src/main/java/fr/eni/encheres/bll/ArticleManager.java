package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DAOFactory;

/**
 * 
 * @author Damien Vassart
 *
 */

public class ArticleManager {
	
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		super();
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	public void addArticle(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int miseAPrix, String rue, String codePostal, String ville) throws BusinessException {
		BusinessException ex = new BusinessException();
		Article article = null;
		
		this.validerNom(nomArticle, ex);
		this.validerDescription(description, ex);
		this.validerDateDebut(dateDebut, ex);
		this.validerDateFin(dateFin, ex);
		this.validerMiseAPrix(miseAPrix, ex);
		this.validerRue(rue, ex);
		this.validerCodePostal(codePostal, ex);
		this.validerVille(ville, ex);
		
		if(!ex.hasErreurs()) {
			article = new Article();
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebut); 
			article.setDateFinEncheres(dateFin); 
			article.setMiseAPrix(miseAPrix);
			article.setPrixVente(miseAPrix);
			
			Retrait retrait = new Retrait();
			retrait.setRue(rue);
			retrait.setCodePostal(codePostal);
			retrait.setVille(ville);
			
			this.articleDAO.insert(article, retrait);
			
		} else {
			throw ex;
		}
	}
	
	public void updateArticle(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int miseAPrix, String rue, String codePostal, String ville) throws BusinessException {
		BusinessException ex = new BusinessException();
		Article article = null;
		
		this.validerNom(nomArticle, ex);
		this.validerDescription(description, ex);
		this.validerDateDebut(dateDebut, ex);
		this.validerDateFin(dateFin, ex);
		this.validerMiseAPrix(miseAPrix, ex);
		this.validerRue(rue, ex);
		this.validerCodePostal(codePostal, ex);
		this.validerVille(ville, ex);
		
		if(!ex.hasErreurs()) {
			article = new Article();
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebut); 
			article.setDateFinEncheres(dateFin); 
			
			Retrait retrait = new Retrait();
			retrait.setRue(rue);
			retrait.setCodePostal(codePostal);
			retrait.setVille(ville);
			
			this.articleDAO.update(article, retrait);
			
		} else {
			throw ex;
		}
	}
	
	public void removeArticle(int noArticle) throws BusinessException {
		this.articleDAO.delete(noArticle); 
	}
	
	public List<Article> getArticles() throws BusinessException {
		return this.articleDAO.selectAll(); 
	}
	
	public List<Article> getArticlesByName(String nomArticle) throws BusinessException {
		return this.articleDAO.selectByName(nomArticle); 
	}
	
	public List<Article> getArticlesByCategory(String categorie) throws BusinessException {
		return this.articleDAO.selectByCategory(categorie); 
	}
	
	public Article getArticle(int noArticle) throws BusinessException {
		return this.articleDAO.selectById(noArticle); 
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
	
	private void validerMiseAPrix(int prix, BusinessException ex) {
		if(prix == 0)
			ex.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_PRIX_ERREUR);
	}
	
	private void validerRue(String rue, BusinessException ex) {
		if(rue == null || rue.trim().equals("") || rue.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_RETRAIT_RUE_ERREUR);
	}
	
	private void validerCodePostal(String codePostal, BusinessException ex) {
		if(codePostal == null || codePostal.trim().equals("") || codePostal.trim().length() > 15)
			ex.ajouterErreur(CodesResultatBLL.REGLE_RETRAIT_CPO_ERREUR);
	}
	
	private void validerVille(String ville, BusinessException ex) {
		if(ville == null || ville.trim().equals("") || ville.trim().length() > 30)
			ex.ajouterErreur(CodesResultatBLL.REGLE_RETRAIT_VILLE_ERREUR);
	}
}
