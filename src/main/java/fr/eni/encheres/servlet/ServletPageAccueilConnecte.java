package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Dorothée Blanchard
 * 
 */

/**
 * Servlet implementation class ServletPageAccueil
 */
@WebServlet("/ServletPageAccueilConnecte") 
//on conserve cette annotation, on écrit entre parentheses l'url d'acces, par exemple /modules/module2/NomDuFichier
public class ServletPageAccueilConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// rd = this.getServletContext().getNamedDispatcher("/WEB-INF/JSP/PageAccueil.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/PageAccueilConnecte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
