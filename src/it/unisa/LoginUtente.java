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

@WebServlet("/LoginUtente")
public class LoginUtente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static UtenteDAO model=new UtenteDAO();
	
	boolean admin;
	public LoginUtente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		String ordini = "ordini";

		
		try {
			UtenteBean user=model.doRetrieveByKey(email,password);
			
			if(checkLogin(email, password, user))
			{
				
				request.getSession().setAttribute("adminRoles", user.getAdmin());
				request.getSession().setAttribute("email", email);
				request.getSession().setAttribute("Nome", user.getNome());
				request.getSession().setAttribute("Cognome", user.getCognome());
				request.getSession().setAttribute("ordini", ordini);
				request.getSession().setAttribute("userID", user.getId());
				request.getSession().setAttribute("telefono", user.getTelefono());
				admin = user.getAdmin();
				System.out.println(admin);				
				if(admin == true)
				{

					response.sendRedirect(request.getContextPath()+"/menuAdmin.jsp");
				}
				else {
					 
					response.sendRedirect(request.getContextPath()+"/menu.jsp");
					
				}
				
			}
			else if(!checkLogin(email,password, user))
			{
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private boolean checkLogin(String email, String password, UtenteBean user){
		
		if(user.getEmail() == null || user.getPassword()== null)
		{
			return false;
		}
		if(user.getEmail().equals(email) && user.getPassword().equals(password) && !user.getEmail().equals("")) {
			admin=user.getAdmin();
			return true;
		}
		return false;

	}
}