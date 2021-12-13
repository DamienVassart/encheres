package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Article;

/**
 * Servlet implementation class ServletAfficherEnchere
 * @author Damien Vassart
 */
@WebServlet("/ServletAfficherEnchere")
public class ServletAfficherEnchere extends HttpServlet {
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
			ArticleManager articleManager = new ArticleManager();
			Article article = new Article();
			int noArticle = Integer.parseInt(request.getParameter("no_article"));
			try {
				article = articleManager.getArticle(noArticle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if(article.getNoUtilisateur() == (int) session.getAttribute("no_utilisateur")) {
				request.setAttribute("article", article);
				rd = request.getRequestDispatcher("modifierVente.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("article", article);
				rd = request.getRequestDispatcher("detailVente.jsp");
				rd.forward(request, response);
			}
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
