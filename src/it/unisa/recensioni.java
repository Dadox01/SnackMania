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


@WebServlet("/recensioni")
public class recensioni extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private recensioniDAO dao = new recensioniDAO();
	
	public recensioni() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.getSession(true);
		ArrayList<RecensioneBean> recensioni = new ArrayList<>();
		try {
			recensioni = (ArrayList<RecensioneBean>) dao.doRetriveAll();
			request.getSession().setAttribute("recensioni", recensioni);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/infoProdotto.jsp");
		System.out.println(recensioni.toString());
	}
}	

