package fr.eni.encheres.bo;

import java.sql.Date;

/**
 * 
 * @author Dorothée Blanchard
 *
 */

public class Enchere {

	// je commence par établir les propriétés
	private Date dateEnchere; 
	private int montantEnchere;
	private int noUtilisateur; 
	private int noArticle; 
	
	// les constructeurs
	public Enchere() {
		
	}
	
	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Enchere(Date dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	// ensuite les getter setter pour ces propriétés
	/**
	 * @return the dateEnchere
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	} 
	
	// ne pas oublier le string
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}

}
