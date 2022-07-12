package it.unisa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProdottoBean;
import model.*;

@WebServlet("/removeCart")
public class removeCart extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static ProdottoDAO model=new ProdottoDAO();
	ArrayList<ProdottoBean> articoli = new ArrayList<ProdottoBean>();	
	
	public removeCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer count = (Integer) request.getSession().getAttribute("count");
		Integer id = Integer.parseInt(request.getParameter("id"));
		articoli = (ArrayList<ProdottoBean>) request.getSession().getAttribute("prodottiCart");
		Iterator<ProdottoBean> prodotti = articoli.iterator();
		
		while(prodotti.hasNext())
		{
			ProdottoBean prod = prodotti.next();
			if(prod.getIdProdotto().equals(id)){
				prodotti.remove();
				request.getSession().removeAttribute("count");
				count--;
				request.getSession().setAttribute("count", count);
				request.getSession().setAttribute("prodottiCart", articoli);
				break;
			}
		}
       
		System.out.println(articoli.toString());
		
			
	}

}