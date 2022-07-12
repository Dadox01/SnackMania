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
import model.ordineDAO;

@WebServlet("/getOrdini")
public class getOrdini extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public getOrdini() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("sono in GetORDINI");
		
		ordineDAO dao=new ordineDAO();
		
		boolean admin;
		
		admin = (boolean)request.getSession().getAttribute("adminRoles");
		if(admin == true)
		{
			ArrayList<OrdineBean> ordini;
			try {
				ordini = (ArrayList<OrdineBean>) dao.doRetriveAll();
				request.getSession().setAttribute("ordini", ordini);
				
				response.sendRedirect(request.getContextPath()+ "/OrdiniA.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else {
			try{
				Integer id = (Integer)request.getSession().getAttribute("userID");
				ArrayList<OrdineBean> ordini= (ArrayList<OrdineBean>) dao.doRetrieveByKeyAll(id);
				request.getSession().setAttribute("ordini", ordini);
				
				response.sendRedirect(request.getContextPath()+ "/Ordini.jsp");
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
