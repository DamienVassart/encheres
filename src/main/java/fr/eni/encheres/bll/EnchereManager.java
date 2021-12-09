/**
 * @author Damien Vassart
 */

package fr.eni.encheres.bll;

import java.time.LocalDateTime;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.dal.DAOFactory;

public class EnchereManager {
	private EnchereDAO enchereDAO; // TODO: créer EnchereDAO (@Lydie)
	
	public EnchereManager() {
		super();
		this.enchereDAO = DAOFactory.getEnchereDAO(); // TODO: ajouter méthode getEnchereDAO à DAOFactory (@Laurane)
	}
	
	public void addEnchere(int noUtilisateur, int noArticle, LocalDateTime dateEnchere, int montantEnchere) {
		// TODO
	}
	
	public void getEnchereByNoArticle(int noArticle) {
		// TODO
	}
	
	public void getEnchereByNoUtilisateur(int noUtilisateur) {
		// TODO
	}
	
	public void removeEnchere(int noArticle) {
		// TODO
	}
	
	public void validerPrix(int prix, BusinessException ex) {
		// TODO
	}
}
