package fr.eni.encheres.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 
* @author Dorothée Blanchard
* travail en cours
* 
*/

/**
 * Servlet implementation class ServletLienLogoEncheres
 */
@WebServlet("/servlet/ServletLienLogoEncheres") 
// on conserve cette annotation, on écrit entre parentheses l'url d'acces, par exemple /modules/module2/NomDuFichier
public class ServletLienLogoEncheres extends HttpServlet {

	/**
	 * Default constructor.
	 */
	public ServletLienLogoEncheres() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name=request.getParameter("welcome"); // modifier le nom en vert
		response.sendRedirect("mainPageUrl");  // modifier l'url en vert
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("ServletPageAccueil");
		doGet(request, response);
	}
	
	

}
