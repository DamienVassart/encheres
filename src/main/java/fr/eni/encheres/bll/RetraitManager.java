/**
 * @author Damien Vassart
 */

package fr.eni.encheres.bll;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitManager {
	// Si erreur de compilation: ArticleDAO encore non créé
		// ne pas tenter de résoudre le problème et attendre que la personne concernée ait créé le compossant manquant
		private RetraitDAO retraitDAO;
		
		// Si erreur de compilation: DAOFactory encore non créé
		// ne pas tenter de résoudre le problème et attendre que la personne concernée ait créé le compossant manquant
		public RetraitManager() {
			super();
			this.retraitDAO = DAOFactory.getRetraitDAO();
		}
		
		public void addRetrait(String rue, String codePostal, String ville) {
			// TODO
		}
		
		public void updateRetrait(String rue, String codePostal, String ville) {
			// TODO
		}
		
		public void deleteRetrait(int noArticle) {
			// TODO
		}
}
