package it.unisa;


import java.io.IOException;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DettagliOrdineBean;
import bean.OrdineBean;
import bean.ProdottoBean;
import bean.UtenteBean;
import model.*;

@WebServlet("/pagamento")
public class pagamento extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static UtenteDAO model=new UtenteDAO();
	static ordineDAO ord = new ordineDAO();
	private UtenteBean utente = new UtenteBean();
	private OrdineBean ordine = new OrdineBean();
	private DettagliOrdineDAO dao = new DettagliOrdineDAO();
	private DettagliOrdineBean composizione = new DettagliOrdineBean();
	boolean admin;
	public pagamento() {
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String email = (String) request.getSession().getAttribute("email");
		ArrayList<ProdottoBean> prodotti = (ArrayList<ProdottoBean>) request.getSession().getAttribute("prodottiCart");
		Float totale = Float.parseFloat(request.getParameter("totale"));
		System.out.println(totale);
		
		ArrayList<String> descrizione = new ArrayList<String>();
		
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String cap = request.getParameter("cap");
		String indirizzo = request.getParameter("adress");
		
		
		Iterator<ProdottoBean> prodotto = prodotti.iterator();
		
		while(prodotto.hasNext())
		{
			ProdottoBean prod = prodotto.next();
			descrizione.add(prod.getNome());
		}
		
		
		ordine.setDescrizione(descrizione.toString());
		ordine.setCosto(totale);
		ordine.setDestinazione(indirizzo);
		ordine.setNumeroProdotti(prodotti.size()+1);
		ordine.setSpedizione(LocalDate.now());
		ordine.setCostoSpedizione(0.0f);
		
		
		if(email != null) {
			try {
				utente = model.doRetrieveByEmail(email);
				ordine.setCliente_Ordine(utente.getId());
				ord.doSaveCliente(utente, ordine);
				
					composizione.setIdOrdine(ordine.getIdOrdine());
					composizione.setIva(22);
					composizione.setPrezzo(ordine.getCosto());
					composizione.setQuantita(ordine.getNumeroProdotti());
					
					
				dao.doSave(composizione);
				prodotti.clear();
				request.getSession().setAttribute("prodottiCart", prodotti);
				request.getSession().removeAttribute("count");
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		if(email == null) {
			try {
				ord.doSave(ordine);
				prodotti.clear();
				request.getSession().setAttribute("prodottiCart", prodotti);
				request.getSession().removeAttribute("count");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
}
