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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		Date dateDebut = null;
		Date dateFin = null;
		
		String nomArticle = request.getParameter("nom_article");
		String description = request.getParameter("description");
		String noCategorie = request.getParameter("no_categorie");
		String miseAPrix = request.getParameter("prix_initial");
		String lectureDateDebut = request.getParameter("date_debut");
		String lectureDateFin = request.getParameter("date_fin");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		
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
		
		if(listeCodesErreur.size() > 0) {
			request.setAttribute("listeCodesErreur", listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp");
			rd.forward(request, response);
		} else {
			// TODO: si pas d'erreur, insérer l'article dans la table Articles_Vendus 
			// et les données relatives au retrait dans la table Retraits
		}
		 
	}

}
