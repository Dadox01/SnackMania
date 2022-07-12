package it.unisa;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UtenteBean;
import model.*;

@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static UtenteDAO model=new UtenteDAO();
	private UtenteBean bean= new UtenteBean();
	private UtenteBean natale = new UtenteBean();
	boolean admin;
	public Registrazione() {
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		bean.setEmail(request.getParameter("Email"));
		bean.setPassword(request.getParameter("Password"));
		bean.setNome(request.getParameter("Nome"));
		bean.setCognome(request.getParameter("Cognome"));
		String confpass = request.getParameter("ConfPassword");
		
		
		
		try {
			natale = model.doRetrieveByEmail(bean.getEmail());
		} catch (SQLException e) {
			
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			e.printStackTrace();
			return;
		}
		
		
	 	try {
	 		if(confpass.equals(request.getParameter("Password")) && natale.getEmail() == null)
	 			model.doSave(bean);

		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			e.printStackTrace();
			return;
		}
	 	
	 	response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
	
}
