package fr.eni.encheres.messages;

/**
 * @author Damien Vassart
 */

import java.util.ResourceBundle;

public class LecteurMessage {
	private static ResourceBundle rb;
	
	static {
		try {
			rb = ResourceBundle.getBundle("fr.eni.encheres.messages.messages_erreur"); // TODO: créer et compléter le fichier messages_erreur.properties (@Laurane)
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getMessageErreur(int code) {
		String message = "";
		try
		{
			if(rb!=null)
			{
				message = rb.getString(String.valueOf(code));
			}
			else
			{
				message="Problème à la lecture du fichier contenant les messages";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			message="Une erreur inconnue est survenue";
		}
		return message;
	}
}
