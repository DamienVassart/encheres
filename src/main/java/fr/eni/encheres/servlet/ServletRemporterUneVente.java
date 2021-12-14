package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;



/**
 * 
 * @author Lydie Allart
 *
 */

	// Servlet implementation class ServletRemporterUneVente
	@WebServlet("/ServletRemporterUneVente")
	public class ServletRemporterUneVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public ServletRemporterUneVente() {
		super();
	}
	
	
	@Override
	public void init () throws ServletException {
		
	}
	
	//Genèrer la réponse à une requête de type Get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RemporterUneVente.jsp");
		
		int noArticle = Integer.parseInt(request.getParameter("id"));
		Article article = Article.getInstance().select(noArticle);
		Categorie categorie = Categorie.getInstance().select(article.getNoCategorie());
		Utilisateur utilisateur= Utilisateur.getInstance().selectUser(article.getNoUtilisateur());
		Enchere enchere = Enchere.getInstance().selectEnchere(noArticle);
		request.setAttribute("enchere", enchere);
		request.setAttribute("article", article);
		request.setAttribute("categorie", categorie);
		request.setAttribute("utilisateur", utilisateur);
		
		
		rd.forward(request, response);
	}

	//Genèrer la réponse à une requête de type Post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.getWriter().append("montantDerniereEnchere:").append(String.valueOf(this.?));
		
		//1-récupérer sa connection--@Laurane
		
		//2-
		
		doGet(request, response);
	}
		
		//Dernière enchère au moment de la fin enchère
		int montantEnchere  = Integer.parseInt(request.getParameter("montant_enchere"));
		
		//Intégrer Message "Vous avez remporté l'enchère"?
	
		//Retrait de la marchandise
		
		
		//prévoir à détruire l'enchère quand remporté?
		@Override
		public void destroy() {
		//this.?;
		super.destroy();
	}
		
	}
