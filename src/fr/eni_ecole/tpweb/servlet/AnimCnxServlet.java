package fr.eni_ecole.tpweb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni_ecole.tpweb.bo.Animateur;
import fr.eni_ecole.tpweb.dao.DAOAnimateur;

/**
 * Servlet implementation class AnimCnxServlet
 */
public class AnimCnxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String email;
	String password;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimCnxServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Méthode en charge de traiter la requête et fournir la réponse.
	 * @param request
	 * @param response
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(true);
		rd = request.getServletContext().getRequestDispatcher("/portailAnimateur.jsp");
		
		// Récupérer email et password fournis
		String email = (String) request.getAttribute("login");
		String password = (String) request.getAttribute("motdepasse");
		
		// Récupérer l'animateur en BdD coorespondant aux paramètres fournis
		try {
			Animateur animCourant = new DAOAnimateur().getByEmailAndPassword(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
