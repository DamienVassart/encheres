package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author Laurane Marie
 *
 */

public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private boolean estVendu;
	private Retrait Retrait = new Retrait();
	private Categorie Categories = new Categorie();
	private ArrayList<Enchere> encheres = new ArrayList<>();

	public Article(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEnchere, int miseAPrix, int prixVente, boolean estVendu) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.estVendu = estVendu;

	}

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

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
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

	public Retrait getRetrait() {
		return Retrait;
	}

	public void setRetrait(Retrait retrait) {
		Retrait = retrait;
	}

	public Categorie getCategories() {
		return Categories;
	}

	public void setCategories(Categorie categories) {
		Categories = categories;
	}

	public ArrayList<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(ArrayList<Enchere> encheres) {
		this.encheres = encheres;
	}

	// @override
	public String toString() {
		return "Article [noArticle : " + this.noArticle + "\n" + "Nom Article : " + this.nomArticle + "\n "
				+ "Description : " + this.description + "\n" + "Début de l'enchère : " + this.dateDebutEncheres + "\n"
				+ "Fin de l'enchère : " + this.dateFinEncheres + "\n" + "Mise à prix : " + this.miseAPrix;
	}

}
