package it.unisa;


import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.ProdottoBean;
import model.ProdottoDAO;


@WebServlet("/AggiungiProdotto")
@MultipartConfig
public class AggiungiProdotto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProdottoDAO dao = new ProdottoDAO();
	private ProdottoBean prodotto = new ProdottoBean();
	
	public AggiungiProdotto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			prodotto.setNome(request.getParameter("NomeProdotto"));
			prodotto.setMarca(request.getParameter("Marca"));
			prodotto.setDescrizione(request.getParameter("Descrizione"));
			prodotto.setQuantita(Integer.parseInt(request.getParameter("Quantita")));
			prodotto.setPeso(request.getParameter("Peso"));
			prodotto.setPrezzo(Float.parseFloat((request.getParameter("Prezzo"))));
			dao.doSave(prodotto);
			String nome = String.valueOf(prodotto.getIdProdotto() +".jpg");
			salva(request.getPart("img"), request.getServletContext().getRealPath(""),nome);
			
		} catch (SQLException e) {
			e.printStackTrace();
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
