package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;

/**
 * 
 * @author Damien Vassart
 *
 */

public class ArticleManager {
	
	public void addArticle(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int miseAPrix) {
		// TODO
	}
	
	public void updateArticle(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int prixVente) {
		// TODO
	}
	
	public void removeArticle(int noArticle) {
		// TODO
	}
	
	public List<Article> getArticles() {
		List<Article> listeArticles = new ArrayList<>();
		// TODO
		return listeArticles;
	}
	
	public List<Article> getArticlesByName(String nomArticle) {
		List<Article> listeArticles = new ArrayList<>();
		// TODO
		return listeArticles;
	}
	
	public List<Article> getArticlesByCategory(String categorie) {
		List<Article> listeArticles = new ArrayList<>();
		// TODO
		return listeArticles;
	}
	
	public Article getArticle(int noArticle) {
		Article article = null;
		// TODO
		return article;
	}
	
	public void validerNom(String nom) {
		// TODO
	}
	
	public void validerDescription(String description) {
		// TODO
	}
	
	public void validerDateDebut(LocalDate dateDebut) {
		// TODO
	}
	
	public void validerDateFin(LocalDate dateFin) {
		// TODO
	}
	
	public void valiserMiseAPrix(int prix) {
		// TODO
	}
}
