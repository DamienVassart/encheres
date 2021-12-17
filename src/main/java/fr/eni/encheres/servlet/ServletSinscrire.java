package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;

/**
 * @author Laurane Marie Servlet implementation class Sinscrire
 */
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/Sinscrire.jsp");
		rd.forward(request, response);

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		String pseudo; 
		String nom;
		String prenom;
		String email;
		String telephone;
		String rue;
		String codePostal;
		String ville;
		String motDePasse;
		String motDePasseConf;
		
		try {
			pseudo = request.getParameter("pseudo");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			telephone = request.getParameter("telephone");
			rue = request.getParameter("rue");
			codePostal = request.getParameter("codePostal");
			ville = request.getParameter("ville");
			motDePasse = request.getParameter("motDePasse");
			motDePasseConf = request.getParameter("motDePasseconf");
			
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			
			utilisateurManager.insert(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			rd = request.getRequestDispatcher("WEB-INF/JSP/PageAccueilConnecte.jsp");
			rd.forward(request, response);
		
		} catch (BusinessException ex) {
			ex.printStackTrace();
			rd = request.getRequestDispatcher("WEB-INF/JSP/Sinscrire.jsp");
			rd.forward(request, response);
		}
		
	}

}

