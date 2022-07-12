package it.unisa;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

@WebServlet("/remove")
public class remove extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static ProdottoDAO model=new ProdottoDAO();
	
	
	public remove() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			model.doDelete(Integer.parseInt(request.getParameter("id")));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("SnackMania/Catalogo"); 
			dispatcher.forward(request, response);

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

		
}
