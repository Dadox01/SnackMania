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

@WebServlet("/updatePass")
public class updatePass extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static UtenteDAO dao=new UtenteDAO();
	static UtenteBean bean = new UtenteBean();
	static UtenteBean nuovo = new UtenteBean();
	
	public updatePass() {
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
		nuovo.setId(bean.getId());
		System.out.println(bean.toString());
		
		String old = request.getParameter("PasswordOld");
			String npass = request.getParameter("PasswordN");
			String cpass = request.getParameter("Password2");
			String dbpass = bean.getPassword();
		System.out.println(old);
		System.out.println(npass);
		System.out.println(cpass);
		System.out.println(dbpass);
			if(old.equals(dbpass))
			{
				if(npass.equals(cpass)) {
					nuovo.setPassword(cpass);
					try {
						dao.doUpdatePass(nuovo);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}		
		
}
