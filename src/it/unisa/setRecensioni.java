package it.unisa;



import javax.servlet.annotation.WebServlet;


import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.RecensioneBean;
import model.recensioniDAO;


@WebServlet("/setRecensioni")
public class setRecensioni extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private recensioniDAO dao = new recensioniDAO();
	private RecensioneBean recensione = new RecensioneBean();
	
	public setRecensioni() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		try {
			recensione.setNome(request.getParameter("name"));
				System.out.println(request.getParameter("name"));
			recensione.setTesto(request.getParameter("rec"));
				System.out.println(request.getParameter("rec"));
			recensione.setIdProdotto(Integer.parseInt(request.getParameter("id")));
					System.out.println(request.getParameter("id"));
			
			dao.doSave(recensione);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}