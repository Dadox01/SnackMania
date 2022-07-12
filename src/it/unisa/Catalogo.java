package it.unisa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import model.ProdottoDAO;

@WebServlet("/Catalogo")
public class Catalogo extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public Catalogo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ProdottoDAO dao=new ProdottoDAO();
		try{
			ServletContext cxt= getServletContext();
			ArrayList<ProdottoBean> articoli=(ArrayList<ProdottoBean>) dao.doRetrieveAll();
			cxt.setAttribute("articoli", articoli);

			response.sendRedirect(request.getContextPath()+"/menu.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
