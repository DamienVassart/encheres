package fr.eni.encheres.servlet;

import java.io.IOException;

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

	/**
	 * Default constructor.
	 */
	public ServletSinscrire() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		rd = this.getServletContext().getRequestDispatcher("Sinscrire.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");

		if (pseudo == null) {
			int errorMessagePseudo = CodesResultatsServlets.FORMAT_PSEUDO_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessagePseudo);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);
			return;
		} else if (nom == null) {
			int errorMessageNom = CodesResultatsServlets.FORMAT_NOM_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageNom);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;

		} else if (prenom == null) {
			int errorMessagePrenom = CodesResultatsServlets.FORMAT_PRENOM_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessagePrenom);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (email == null) {
			int errorMessageEmail = CodesResultatsServlets.FORMAT_EMAIL_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageEmail);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (telephone == null) {
			int errorMessageTelephone = CodesResultatsServlets.FORMAT_TEL_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageTelephone);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (rue == null) {
			int errorMessageRue = CodesResultatsServlets.FORMAT_RUE_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageRue);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (codePostal == null) {
			int errorMessageCPO = CodesResultatsServlets.FORMAT_CPO_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageCPO);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (ville == null) {
			int errorMessageVille = CodesResultatsServlets.FORMAT_VILLE_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageVille);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (motDePasse == null) {
			int errorMessageMDP = CodesResultatsServlets.FORMAT_MDP_NULL;
			request.setAttribute("FORMAT_PSEUDO_NULL", errorMessageMDP);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			dispatcher.forward(request, response);
			return;
		} else {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			try {
			utilisateurManager.insert(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			request.getRequestDispatcher("WEB-INF/index.jsp");
			
		}catch (BusinessException ex){
			ex.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp");
			forward(request, response);
		}
	}

}

	private void forward(HttpServletRequest request, HttpServletResponse response) {
	}
		
	}
