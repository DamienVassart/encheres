package fr.eni.encheres.bo;

import java.util.ArrayList;

/**
 * Définit la Classe Utilisateur
 * @author Damien Vassart
 *
 */

public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal; 
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;
	private ArrayList<Article> articles = new ArrayList<>();
	private ArrayList<Enchere> encheres = new ArrayList<>();
	
	/**
	 * Constructeur pour la classe Utilisateur
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	/**
	 * Constructeur vide
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return this.noUtilisateur;
	}
	
	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return this.pseudo;
	}
	
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}
	
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * @return the rue
	 */
	public String getRue() {
		return this.rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return this.codePostal;
	}
	
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * @return the ville
	 */
	public String getVille() {
		return this.ville;
	}
	
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return this.motDePasse;
	}
	
	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	/**
	 * @return the credit
	 */
	public int getCredit() {
		return this.credit;
	}
	
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	/**
	 * @return the administrateur
	 */
	public boolean isAdministrateur() {
		return this.administrateur;
	}
	
	/**
	 * @param administrateur the administrateur to set
	 */
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	/**
	 * @return the articles
	 */
	public ArrayList<Article> getArticles() {
		return this.articles;
	}

	/**
	 * @param articles the articles to set
	 */
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	/**
	 * @return the encheres
	 */
	public ArrayList<Enchere> getEncheres() {
		return this.encheres;
	}

	/**
	 * @param encheres the encheres to set
	 */
	public void setEncheres(ArrayList<Enchere> encheres) {
		this.encheres = encheres;
	}

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + this.noUtilisateur + ", pseudo=" + this.pseudo + ", nom=" + this.nom + ", prenom="
				+ this.prenom + ", email=" + this.email + ", telephone=" + this.telephone + ", rue=" + this.rue + ", codePostal="
				+ this.codePostal + ", ville=" + this.ville + ", motDePasse=" + this.motDePasse + ", credit=" + this.credit + "]";
	}
	
	
}
