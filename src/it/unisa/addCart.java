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

import bean.ProdottoBean;
import model.*;

@WebServlet("/addCart")
public class addCart extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static ProdottoDAO model=new ProdottoDAO();
	static ArrayList<ProdottoBean> articoli = new ArrayList<ProdottoBean>();
	
	
	public addCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer count = (Integer) request.getSession().getAttribute("count");
		if(count == null)
		{
			count = 0;
		}
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			ProdottoBean product = model.doRetrieveByKey(id);
			
			if(product.getQuantita() > 0)
			{
				count++;
				request.getSession().setAttribute("count", count);
				articoli.add(product);
				request.getSession().setAttribute("prodottiCart", articoli);
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
			
	}

}