package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

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
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;

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
			// La date actuelle:
			LocalDate currentDate = LocalDate.now();
			Date today = Date.valueOf(currentDate);
			
			// chargement des données relatives à l'article
			ArticleManager articleManager = new ArticleManager();
			Article article = new Article();
			int noArticle = Integer.parseInt(request.getParameter("no_article"));
			try {
				article = articleManager.getArticle(noArticle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			EnchereManager enchereManager = new EnchereManager();
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			
			// Définition des attributs qui seront transmis à la jsp dans tous les cas
			request.setAttribute("nom_article", article.getNomArticle());
			request.setAttribute("description", article.getDescription());
			request.setAttribute("prix_initial", article.getMiseAPrix());
			request.setAttribute("rue", article.getRetrait().getRue());
			request.setAttribute("code_postal", article.getRetrait().getCodePostal());
			request.setAttribute("ville", article.getRetrait().getVille());
			
			/*
			 * Si on est le vendeur
			 */
			if(article.getNoUtilisateur() == (int) session.getAttribute("no_utilisateur")) {
				// Si l'enchère n'a pas encore débuté, le vendeur peut encore modifier les détails de la vente
				if(article.getDateDebutEncheres().before(today)) {
					request.setAttribute("date_debut_encheres", article.getDateDebutEncheres());
					request.setAttribute("date_fin_enchere", article.getDateFinEncheres());
					rd = request.getRequestDispatcher("/WEB-INF/modifierVente.jsp");
				} 
				// Sinon, il ne peut que consulter son annonce sans pouvoir enchérir
				else {
					request.setAttribute("role", "vendeur"); // pour désactiver la possibilité d'enchérir dans la jsp
					
					setAttributsSupplementaires(request, article, noArticle, enchereManager, utilisateurManager);
					
					rd = request.getRequestDispatcher("/WEB-INF/detailVente.jsp");
				}
			} 
			/*
			 * si on n'est pas le vendeur
			 */
			else {
				request.setAttribute("role", "acheteur"); // pour laisser la possibilité d'enchérir dans la jsp
				
				setAttributsSupplementaires(request, article, noArticle, enchereManager, utilisateurManager);
				
				String pseudoVendeur = "";
				try {
					pseudoVendeur = utilisateurManager.getUtilisateurById(article.getNoUtilisateur()).getPseudo();
				} catch (BusinessException ex) {
					ex.printStackTrace();
				}
				
				request.setAttribute("vendeur", pseudoVendeur);
				
				rd = request.getRequestDispatcher("/WEB-INF/detailVente.jsp");
			}
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void setAttributsSupplementaires(HttpServletRequest request, Article article, int noArticle,
			EnchereManager enchereManager, UtilisateurManager utilisateurManager) {
		
		request.setAttribute("categorie", article.getNoCategorie());
		
		int meilleureOffre = 0;
		String nomEncherisseur = "";
		
		Enchere derniereEnchere = null;
		try {
			derniereEnchere = enchereManager.getEnchereByNoArticle(noArticle).get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		meilleureOffre = derniereEnchere.getMontantEnchere();
		try {
			nomEncherisseur = utilisateurManager.getUtilisateurById(derniereEnchere.getNoUtilisateur()).getPseudo();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		request.setAttribute("meilleure_offre", meilleureOffre);
		request.setAttribute("nom_encherisseur", nomEncherisseur);
		
		request.setAttribute("date_fin_enchere", article.getDateFinEncheres());
	}

}
