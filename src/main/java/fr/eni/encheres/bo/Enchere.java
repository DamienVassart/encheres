package fr.eni.encheres.bo;

import java.time.LocalDateTime;

/**
 * 
 * @author Dorothée Blanchard
 *
 */

public class Enchere {

	// je commence par établir les propriétés
	private LocalDateTime dateEnchere; 
	private Integer montantEnchere;
	
	// ensuite les getter setter pour ces propriétés
	/**
	 * @return the dateEnchere
	 */
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montantEnchere
	 */
	public Integer getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	} 
	
	// ne pas oublier le string
	@Override
	public String toString() {
		return null;
		
	}

}
