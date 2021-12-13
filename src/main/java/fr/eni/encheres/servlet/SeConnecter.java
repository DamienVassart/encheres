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

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * @author Laurane Marie 
 */

/**
 * Servlet implementation class SeConnecter
 */
@WebServlet("/SeConnecter")
public class SeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SeConnecter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * renvoie à connexion.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		rd = this.getServletContext().getNamedDispatcher("connexion");
		rd.forward(request, response);
	}

	/**
	 * appelle la methode getUtilisateurByName du bll
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("Nom d'utilisateur");
		String motDePasse = request.getParameter("motDePasse");
		String rememberMeStr = request.getParameter("Se Souvenir de Moi");
		boolean remember = "Y".equals(rememberMeStr);

		if (pseudo == null) {
			int errorMessagePseudo = CodesResultatsServlets.FORMAT_PSEUDO_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessagePseudo);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (motDePasse == null) {
			int errorMessageMDP = CodesResultatsServlets.FORMAT_MDP_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageMDP);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp");
			dispatcher.forward(request, response);
			return;
		}
		

		doGet(request, response);
	}

}
