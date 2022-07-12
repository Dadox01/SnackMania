package it.unisa;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProdottoBean;
import model.*;

@WebServlet("/infoProduct")
public class infoProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static ProdottoDAO model=new ProdottoDAO();
	static ProdottoBean prodotto = new ProdottoBean();
	
	
	public infoProduct() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			prodotto = model.doRetrieveByKey(Integer.parseInt(request.getParameter("id")));
			ServletContext cxt= getServletContext();
			cxt.setAttribute("prodotto", prodotto);
			response.sendRedirect("/SnackMania/infoProdotto.jsp");

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

		
}