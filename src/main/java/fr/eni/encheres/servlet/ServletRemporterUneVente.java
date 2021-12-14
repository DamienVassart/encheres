package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.dal.UtilisateurDAO;



/**
 * 
 * @author Lydie Allart
 *
 */

	// Servlet implementation class ServletRemporterUneVente
	@WebServlet("/ServletRemporterUneVente")
	public class ServletRemporterUneVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
			
		//Genèrer la réponse à une requête de type Get
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			String prixVente = request.getParameter("prixVente");
			int montantFinal = Integer.parseInt(request.getParameter("prixVente"));
			
			request.setAttribute("montantFinal", prixVente);
			
			int noArticle = Integer.parseInt(request.getParameter("noArticle"));
			Enchere enchere = new Enchere();
			
			List<Enchere> listeEnchere= new ArrayList();
			
			int montant = 0; //Pour avoir le montant de chaque enchère à entrer en méthode pour recréditer
			int utilisateurEnchere = 0; //Pour recréditer les noUtilisateur du montant de leur enchère ou débiter le gagnant.
			Utilisateur utilisateur = new Utilisateur(); //A utiliser pour les recréditer
			int noUtilisateur;		
			String pseudoGagnant = request.getParameter("PseudoGagnant"); //On récupère le pseudo de celui qui a gagné
			int utilisateurVendeur =0;//Pour créditer et payer le vendeur
			
			//Enchère finale
			try {
				//miseAPrix = ArticleDAO.AfficherArticle(miseAPrix);
				//listeEnchere = EnchereDAO.listeEnchere(miseAPrix);
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
			
			//On recrédite tous les utilisateurs qui ont fait des enchères
			
			for (Enchere enchere : listeEnchere) {
				utilisateurEnchere = enchere.getNoUtilisateur();
				
				try {
					utilisateur = UtilisateurDAO.ajouterUtilisateur(utilisateurEnchere); //Utilisateur à créditer?
					montant = enchere.getMontantEnchere() + utilisateur.getCredit(); //Montant à créditer + crédit précèdent
					UtilisateurDAO.modifierCredit(montant, utilisateurEnchere); //Méthode pour modifier le crédit en BD?
				} catch (BusinessException e) {
					
					e.printStackTrace();
				}
				
			}
			
			//Paiement du vendeur
			
			utilisateurVendeur = enchere.getNoUtilisateur();
			
			try {
				utilisateur = UtilisateurDAO.obtenirUtilisateur(utilisateurVendeur);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			
			montant = utilisateur.getCredit() + prixVente;
			
			//Crédit du vendeur
			try {
				UtilisateurDAO.modifierCredit(montant, utilisateurVendeur);
				
			//Débit du gagnant
				utilisateur = UtilisateurDAO.obtenirPseudo(pseudoGagnant);
			} catch (BusinessException e) {
				e.printStackTrace();
			} 
			
			
			montant = utilisateur.getCredit() - prixVente;
			utilisateurEnchere = utilisateur.getNoUtilisateur();
			
			try {
				UtilisateurDAO.modifierCredit(montant, utilisateurEnchere);
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/RemporterUneVente.jsp").forward(request, response);
		}

		
		
		//Genèrer la réponse à une requête de type Post
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException  {
			doGet(request, response);
		}
			
		
		//prévoir à détruire l'enchère quand remporté?
		@Override
		public void destroy() {
		//this.?;
		super.destroy();
	}
		
}
