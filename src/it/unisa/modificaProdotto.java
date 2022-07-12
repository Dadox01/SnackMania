package it.unisa;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.ProdottoBean;
import model.ProdottoDAO;

@WebServlet("/modificaProdotto")
@MultipartConfig
public class modificaProdotto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static ProdottoDAO model=new ProdottoDAO();
	static ProdottoBean prodotto = new ProdottoBean();
	static ProdottoBean old = new ProdottoBean();
	
	
	public modificaProdotto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ServletContext cxt= getServletContext();
		old = (ProdottoBean)cxt.getAttribute("prodottoModifica");
		
		try {
		String nomeProdotto = request.getParameter("NomeProdotto");
		String descrizione = request.getParameter("desc");
		Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
		Integer quantita = Integer.parseInt(request.getParameter("quantita"));
	
		prodotto.setIdProdotto(old.getIdProdotto());
		prodotto.setDescrizione(descrizione);
		prodotto.setMarca(request.getParameter("marcaProdotto"));
		prodotto.setPeso(request.getParameter("peso"));
		prodotto.setNome(nomeProdotto);
		prodotto.setPrezzo(prezzo);
		prodotto.setQuantita(quantita);
		
		//MODELs
		
		model.doDelete(old.getIdProdotto());
		
		model.doSave2(prodotto);
		
		//Save image
		String nome = String.valueOf(prodotto.getIdProdotto() +".jpg");
		salva(request.getPart("img"), request.getServletContext().getRealPath(""),nome);
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	protected void salva(Part filepart, String path, String nome)throws  IOException{
		
		String percorso = path + "ImgC/";
		OutputStream out = null;
		InputStream in = null;
		
		try {
			out = new FileOutputStream(new File(percorso + File.separator + nome));
			in = filepart.getInputStream();
			int i = 0;
			final byte[] bites = new byte[1024];
			while((i = in.read(bites))!= -1) {
				out.write(bites, 0 , i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(out != null) {
				out.close();
			}
			if(in != null) {
				in.close();
			}
		}
	}
	
	
}