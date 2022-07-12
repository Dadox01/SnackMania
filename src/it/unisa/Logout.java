package it.unisa;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProdottoBean;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<ProdottoBean> prodotti = new ArrayList<ProdottoBean>();

	public Logout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ServletContext cxt= getServletContext();
		request.getSession().removeAttribute("adminRoles");
		request.getSession().removeAttribute("email");
		request.getSession().removeAttribute("count");
		request.getSession().removeAttribute("prodottiCart");
		request.getSession().invalidate();
		cxt.removeAttribute("user");
		cxt.removeAttribute("admin");
		cxt.removeAttribute("utente");
		response.sendRedirect(request.getContextPath()+"/menu.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}