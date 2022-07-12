package it.unisa;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UtenteBean;
import model.*;

@WebServlet("/update")
public class update extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static UtenteDAO dao=new UtenteDAO();
	static UtenteBean bean = new UtenteBean();
	static UtenteBean nuovo = new UtenteBean();
	
	public update() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		HttpSession sessione = request.getSession(true);
		String email = (String) sessione.getAttribute("email");
		try {
			bean = (UtenteBean) dao.doRetrieveByEmail(email);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String mail = request.getParameter("Email");
		String telefono = request.getParameter("Telefono");
		
			nuovo.setId(bean.getId());
			
			if(nome == null)
			{
				nuovo.setNome(bean.getNome());
			}
			else {
				nuovo.setNome(nome);
			}
			if(cognome == null)
			{
				nuovo.setCognome(bean.getCognome());
			}
			else {
				nuovo.setCognome(cognome);
			}
			if(mail == null)
			{
				nuovo.setEmail(bean.getEmail());
			}
			else {
				nuovo.setEmail(mail);
			}
			if(telefono == null)
			{
				nuovo.setTelefono(bean.getTelefono());
			}
			else {
				nuovo.setTelefono(telefono);
			}
			
			
				try {
						dao.doUpdate(nuovo);
						request.getSession().setAttribute("email", nuovo.getEmail());
						request.getSession().setAttribute("Nome", nuovo.getNome());
						request.getSession().setAttribute("Cognome", nuovo.getCognome());
						request.getSession().setAttribute("telefono", nuovo.getTelefono());
						return;
					} catch (SQLException e) {
						e.printStackTrace();
			}
		
		
	}

		
}
