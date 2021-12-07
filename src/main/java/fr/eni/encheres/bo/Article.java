package fr.eni.encheres.bo;

import java.time.LocalDateTime;

/**
 * 
 * @author Laurane Marie
 *
 */

public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private boolean estVendu;

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public boolean getEstVendu() {
		return estVendu;
	}

	public void setEstVendu(boolean estVendu) {
		this.estVendu = estVendu;
	}

	public static void add(Article article) {

	}

	// @override
	public String toString() {
		return "Article [noArticle : " + this.noArticle + "\n" + "Nom Article : " + this.nomArticle + "\n "
				+ "Description : " + this.description + "\n" + "Début de l'enchère : " + this.dateDebutEncheres + "\n"
				+ "Fin de l'enchère : " + this.dateFinEncheres + "\n" + "Mise à prix : " + this.miseAPrix;
	}
}
