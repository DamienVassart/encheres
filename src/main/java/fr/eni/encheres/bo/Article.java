package fr.eni.encheres.bo;

import java.sql.Date;
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
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private boolean estVendu;
	private int noCategorie;
	private int noUtilisateur;
	private Retrait Retrait = new Retrait();
	private Categorie Categories = new Categorie();
	private ArrayList<Enchere> encheres = new ArrayList<>();

	public Article(int noArticle, String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int miseAPrix, int prixVente, boolean estVendu) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.estVendu = estVendu;

	}

	public Article() {
		super();

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

	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(Date dateFinEncheres) {
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

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	// @override
	public String toString() {
		return "Article [noArticle : " + this.noArticle + "\n" + "Nom Article : " + this.nomArticle + "\n "
				+ "Description : " + this.description + "\n" + "Début de l'enchère : " + this.dateDebutEncheres + "\n"
				+ "Fin de l'enchère : " + this.dateFinEncheres + "\n" + "Mise à prix : " + this.miseAPrix;
	}

}
