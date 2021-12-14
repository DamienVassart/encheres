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
@WebServlet("/SeConnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletSeConnecter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * renvoie à connexion.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		rd = this.getServletContext().getRequestDispatcher("SeConnecter.jsp");
		rd.forward(request, response);
	}

	/**
	 * appelle la methode getUtilisateurByName du bll
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("Nom d'utilisateur");
		String motDePasse = request.getParameter("motDePasse");
		
	

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
		} else {
			try {
			
					Utilisateur utilisateur = UtilisateurManager.getUtilisateurByName(pseudo);
				} catch (BusinessException ex) {
					ex.printStackTrace();
					request.getRequestDispatcher("WEB-INF/index.jsp");
					forward(request, response);
				}
			
				
			}

	doGet(request, response);
	}

private void forward(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
