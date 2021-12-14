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
import javax.tools.ForwardingFileObject;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * @author Laurane Marie 
 */

/**
 * Servlet implementation class SeConnecter
 */
@WebServlet("/ServletSeConnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletSeConnecter() {

	}

	/**
	 * renvoie à Seconnecter.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/SeConnecter.jsp");
		rd.forward(request, response);
	}

	/**
	 * appelle la methode getUtilisateurByName du bll
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("");
		String motDePasse = request.getParameter("motDePasse");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		if (pseudo == null) {
			int errorMessagePseudo = CodesResultatsServlets.FORMAT_PSEUDO_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessagePseudo);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/SeConnecter.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (motDePasse == null) {
			int errorMessageMDP = CodesResultatsServlets.FORMAT_MDP_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageMDP);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/SeConnecter.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (pseudo.length() == 0) {
			int errorMessagePseudoFormat = CodesResultatsServlets.FORMAT_PSEUDO_ERREUR;
			request.setAttribute("FORMAT_PSEUDO_ERREUR", errorMessagePseudoFormat);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/SeConnecter.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (motDePasse.length() == 0) {
			int errorMessageMDPFormat = CodesResultatsServlets.FORMAT_MDP_ERREUR;
			request.setAttribute("FORMAT_PSEUDO_ERREUR", errorMessageMDPFormat);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/SeConnecter.jsp");
			dispatcher.forward(request, response);
			return;
		} else {
			try {
				Utilisateur utilisateurManager =  UtilisateurManager.getUtilisateurByName(pseudo);
			} catch (BusinessException ex) {
				ex.printStackTrace();
			}
			

	

}
}
}
