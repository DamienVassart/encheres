package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAjouterVente
 * @author Damien Vassart
 */
@WebServlet("/ServletAjouterVente")
public class ServletAjouterVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		if(session.getAttribute("no_utilisateur") != null) { // A confirmer
			rd = request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		request.setCharacterEncoding("UTF-8");
		
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		Date dateDebut = null;
		Date dateFin = null;
		
		String nomArticle = request.getParameter("nom_article");
		String description = request.getParameter("description");
		
		String lectureDateDebut = request.getParameter("date_debut");
		String lectureDateFin = request.getParameter("date_fin");
		
		try {
			dateDebut = Date.valueOf(lectureDateDebut);
		} catch (Exception ex) {
			ex.printStackTrace();
			listeCodesErreur.add(CodesResultatsServlets.FORMAT_DATE_DEBUT_ERREUR);
		}
		
		try {
			dateFin = Date.valueOf(lectureDateFin);
		} catch (Exception ex) {
			ex.printStackTrace();
			listeCodesErreur.add(CodesResultatsServlets.FORMAT_DATE_FIN_ERREUR);
		}
		
		int miseAPrix = Integer.parseInt(request.getParameter("prix_initial"));
		
		String lectureRue = request.getParameter("rue");
		String lectureCodePostal = request.getParameter("code_postal");
		String lectureVille = request.getParameter("ville");
		
		String rue = lectureRue.trim().equals("") ? (String) session.getAttribute("rue") : lectureRue; // A confirmer
		String codePostal = lectureCodePostal.trim().equals("") ? (String) session.getAttribute("code_postal") : lectureCodePostal; // A confirmer
		String ville =  lectureVille.trim().equals("") ? (String) session.getAttribute("ville") : lectureVille; // A confirmer
		
		int noUtilisateur = (int) session.getAttribute("no_utilisateur");
		int noCategorie = Integer.parseInt(request.getParameter("no_categorie"));
		
		if(listeCodesErreur.size() > 0) {
			request.setAttribute("listeCodesErreur", listeCodesErreur);
			rd = request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp");
			rd.forward(request, response);
		} else {
			ArticleManager articleManager = new ArticleManager();
			try {
				articleManager.addArticle(nomArticle, description, dateDebut, dateFin, miseAPrix, rue, codePostal, ville, noUtilisateur, noCategorie);
				rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
				rd.forward(request, response);
			} catch (BusinessException ex) {
				ex.printStackTrace();
				rd = request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp");
				rd.forward(request, response);
			}
			
		}
		 
	}

}
