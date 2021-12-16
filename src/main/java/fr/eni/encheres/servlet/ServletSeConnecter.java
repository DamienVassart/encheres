
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
 * @author Laurane Marie
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
		
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");
		
		if(pseudo == null || pseudo.trim().equals("") || motDePasse == null || motDePasse.trim().equals("")) {
			request.setAttribute("errorString", "L'identifiant et le mot de passe sont obligatoires");
			rd = request.getRequestDispatcher("/WEB-INF/JSP/SeConnecter.jsp");
		} 
		else {
			try {
				utilisateur = utilisateurManager.getUtilisateurByPseudo(pseudo);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if(utilisateur != null) {
				
				if(motDePasse.equals(utilisateur.getMotDePasse())) {
					
					HttpSession session = request.getSession();
					rd = request.getRequestDispatcher("/WEB-INF/JSP/PageAccueilConnecte.jsp");
				} 
				else {
					request.setAttribute("errorString", "Le mot de passe est invalide");
					rd = request.getRequestDispatcher("/WEB-INF/JSP/SeConnecter.jsp");
				}
				
			} 
			else {
				request.setAttribute("errorString", "Aucun compte associé à cet identifiant");
				rd = request.getRequestDispatcher("/WEB-INF/JSP/SeConnecter.jsp");
			}
		}
		
		rd.forward(request, response);
	}

	

}
