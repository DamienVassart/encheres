package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Lydie Allart
 */

	//Servlet implementation class ServletListerLesEnchereEnModeConnecte
 
	@WebServlet("/ServletListerLesEnchereEnModeConnecte")
	public class ServletListerLesEnchereEnModeConnecte extends HttpServlet {
		private static final long serialVersionUID = 1L;
    
    public ServletListerLesEnchereEnModeConnecte() {
    	super();
    }

  //Genèrer la réponse à une requête de type Get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//Genèrer la réponse à une requête de type Post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
