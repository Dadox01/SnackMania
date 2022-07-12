package it.unisa;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UtenteBean;
import model.*;

@WebServlet("/profile")
public class profile extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static UtenteDAO model=new UtenteDAO();
	static UtenteBean bean = new UtenteBean();
	static UtenteBean nuovo = new UtenteBean();
	
	public profile() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ServletContext cxt= getServletContext();
		UtenteDAO dao = new UtenteDAO();
		
		HttpSession sessione = request.getSession(true);
		String email = (String) sessione.getAttribute("email");
		try {
			bean = (UtenteBean) dao.doRetrieveByEmail(email);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cxt.setAttribute("utente", bean);
		response.sendRedirect(request.getContextPath()+"/profilo.jsp");
		
	}

		
}
