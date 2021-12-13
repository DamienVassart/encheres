package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * @author Laurane Marie
 * Servlet implementation class SupprimerMonCompter
 */
@WebServlet("/SupprimerMonCompter")
public class ServletSupprimerMonCompter extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ServletSupprimerMonCompter() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String noUtilisateur=request.getParameter("noUtilisateur");
		int id = Integer.parseInt(noUtilisateur);
		try {
			UtilisateurDAO.delete(noUtilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		response.sendRedirect("Suppression");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
