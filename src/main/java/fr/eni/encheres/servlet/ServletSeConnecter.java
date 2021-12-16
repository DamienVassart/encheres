
package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletSeConnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * renvoie à Seconnecter.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/SeConnecter.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		
		// On récupère l'identifiant et le mot de passe
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");
		
		// Si l'identifiant et / ou le mot de passe sont vides
		if(pseudo == null || pseudo.trim().equals("") || motDePasse == null || motDePasse.trim().equals("")) {
			request.setAttribute("errorString", "L'identifiant et le mot de passe sont obligatoires");
			rd = request.getRequestDispatcher("/WEB-INF/JSP/SeConnecter.jsp");
		} 
		// si l'identifiant et le mot de passe ont bien été renseignés
		else {
			// appelle la méthode de sélection par pseudo du BLL
			try {
				utilisateur = utilisateurManager.getUtilisateurByPseudo(pseudo);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			// si un utilisateur avec ce pseudo est trouvé
			if(utilisateur != null) {
				
				// compare le mot de passe saisi avec celui stocké en BDD
				// si il est valide
				if(motDePasse.equals(utilisateur.getMotDePasse())) {
					/*
					 * TODO: créer une session ou un cookie
					 */
					HttpSession session = request.getSession();
					rd = request.getRequestDispatcher("/WEB-INF/JSP/PageAccueil.jsp");
				} 
				// sinon
				else {
					request.setAttribute("errorString", "Le mot de passe est invalide");
					rd = request.getRequestDispatcher("/WEB-INF/JSP/SeConnecter.jsp");
				}
				
			} 
			// si aucun utilisateur avec ce pseudo n'est trouvé
			else {
				request.setAttribute("errorString", "Aucun compte associé à cet identifiant");
				rd = request.getRequestDispatcher("/WEB-INF/JSP/SeConnecter.jsp");
			}
		}
		
		rd.forward(request, response);
	}

	

}
