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

	/**
	 * Default constructor.
	 */
	public ServletSinscrire() {
	}

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

		List<Integer> listeCodeErreur = new ArrayList<>();
		RequestDispatcher rd = null;
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String motDePasseConf = request.getParameter("motDePasseconf");

		if (pseudo == null) {

			listeCodeErreur.add(CodesResultatsServlets.FORMAT_PSEUDO_NULL);

		}
		if (nom == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_NOM_NULL);

		}
		if (prenom == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_PRENOM_NULL);

		}
		if (email == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_EMAIL_NULL);

		}
		if (telephone == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_TEL_NULL);

		}
		if (rue == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_RUE_NULL);

		}
		if (codePostal == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_CPO_NULL);

		}
		if (ville == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_VILLE_NULL);

		}
		if (motDePasse == null) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_MDP_NULL);
		}
		if (motDePasseConf == null || motDePasseConf != motDePasse) {
			listeCodeErreur.add(CodesResultatsServlets.FORMAT_MDPCONF_NULL);

		}
		if (listeCodeErreur.size() > 0) {
			request.setAttribute("errorString", listeCodeErreur);
			rd = request.getRequestDispatcher("/WEB-INF/JSP/Sinscrire.jsp");
		}

		else {

			UtilisateurManager utilisateurManager = new UtilisateurManager();
			try {
				utilisateurManager.insert(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
				rd = request.getRequestDispatcher("WEB-INF/JSP/PageAccueil.jsp");
			} catch (BusinessException ex) {
				request.setAttribute("errorString", ex.getListeCodesErreur());
				rd = request.getRequestDispatcher("WEB-INF/JSP/Sinscrire.jsp");
			}
		}
		rd.forward(request, response);
	}

}
