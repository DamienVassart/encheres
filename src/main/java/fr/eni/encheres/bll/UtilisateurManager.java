package fr.eni.encheres.bll;
/**
 * 
 * @author Lydie Allart
 *
 */
public class UtilisateurManager {
	
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
}