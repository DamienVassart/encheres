package fr.eni.encheres.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * @author Laurane Marie Servlet implementation class ModifierMonProfil
 *
 */
@WebServlet("/ModifierMonProfil")
public class ServletModifierMonProfil<Profil, Emp> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletModifierMonProfil() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/ModifierProfil.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");

		Utilisateur e = new Utilisateur();
		e.setPseudo(pseudo);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setEmail(email);
		e.setTelephone(telephone);
		e.setRue(rue);
		e.setCodePostal(codePostal);
		e.setVille(ville);
		e.setMotDePasse(motDePasse);

		int status = 0;
		try {
			status = UtilisateurDAO.update(e);
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
		if (status > 0) {
			response.sendRedirect("Profil");
		} else {
			out.println("Impossible de modifier le profil");
		}
		out.close();

	}

}
