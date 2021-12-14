package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.Article;

/**
 * Servlet implementation class ServletEncherir
 * @author Damien Vassart
 */
@WebServlet("/ServletEncherir")
public class ServletEncherir extends HttpServlet {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		
		LocalDateTime currentDate = LocalDateTime.now();
		Date dateEnchere = (Date) Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());
		
		int noUtilisateur = (int) session.getAttribute("no_utilisateur");
		
		Article article = null;
		int noArticle = Integer.parseInt(request.getParameter("no_article"));
		ArticleManager articleManager = new ArticleManager();
		try {
			article = articleManager.getArticle(noArticle);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		int prixVente = article.getPrixVente();
		
		int montantEnchere = Integer.parseInt(request.getParameter("montant_enchere"));
		
		EnchereManager enchereManager = new EnchereManager();
		try {
			enchereManager.addEnchere(noUtilisateur, noArticle, dateEnchere, prixVente, montantEnchere);
			rd = request.getRequestDispatcher("/WEB-INF/detailVente.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			rd = request.getRequestDispatcher("/WEB-INF/pageAccueil.jsp");
			rd.forward(request, response);
		}
		
	}

}
