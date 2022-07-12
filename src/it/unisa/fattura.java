package it.unisa;


import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import bean.DettagliOrdineBean;
import bean.OrdineBean;
import bean.ProdottoBean;
import bean.UtenteBean;
import model.DettagliOrdineDAO;
import model.ProdottoDAO;
import model.UtenteDAO;
import model.ordineDAO;


//Servlet che produce il PDF di un ordine
@WebServlet("/fattura")
public class fattura extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO model = new UtenteDAO();
	private ordineDAO dao = new ordineDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fattura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("creo la fattura");
		
		response.setContentType("application/pdf");
		  
        response.setHeader("Content-disposition","inline; filename = invoice.pdf");
        
        try {
			UtenteBean utente = model.doRetrieveByKey((Integer)request.getSession().getAttribute("userID"));
		} catch (SQLException e2) {
			e2.printStackTrace();
		}		
		
		int id = 0;
		
		OrdineBean ordine = new OrdineBean();
		
		try {
			id = (int) Integer.valueOf(request.getParameter("idOrdine"));
			ordine = dao.doRetrieveByID(id);
		}
		catch (Exception e) {
			System.out.println("Parsing non riuscito del valore Integer");
		}
		
		System.out.println(ordine.toString());
		
		UtenteDAO utenti = new UtenteDAO();
		
		DettagliOrdineDAO fatture = new DettagliOrdineDAO();
		ProdottoDAO fotoProdotti = new ProdottoDAO();
	
		
		
		DettagliOrdineBean fattura = null;
		try {
			System.out.println("Ricerca composizione dell'ordine");
			fattura = fatture.doRetrieveById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println(fattura.toString());
		
		DecimalFormat formatoPrezzo = new DecimalFormat();
		formatoPrezzo.setMaximumFractionDigits(2);
		formatoPrezzo.setMinimumFractionDigits(2);
		double totaleFattura=0;
        
        
        try {
  
            Document document = new Document();
  
            PdfWriter.getInstance(document, response.getOutputStream());
  
            document.open();
            
            Font fontCliente = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            
            String relativeWebPath = "/logo/LOGO_FINALE.png";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            

            Image logo = Image.getInstance(absoluteDiskPath);
            
            logo.scalePercent(10);
            
            PdfPTable logoAndUser = new PdfPTable(2);
          
            
            PdfPCell logoSinistro = new PdfPCell(logo);
           
            
            UtenteBean utenteFattura = new UtenteBean();
            
            
			try {
				utenteFattura = model.doRetrieveByKey(ordine.getCliente_Ordine());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            PdfPCell ClienteDestro = new PdfPCell(new Phrase("Cliente: \n" + utenteFattura.getNome()+ " " + utenteFattura.getCognome()+ "\n" + ordine.getDestinazione() + " ",fontCliente ));
            
         
            
            logoSinistro.setBorder(Rectangle.NO_BORDER);
            ClienteDestro.setBorder(Rectangle.NO_BORDER);
            ClienteDestro.setHorizontalAlignment(Element.ALIGN_RIGHT);
            logoAndUser.addCell(logoSinistro);
            logoAndUser.addCell(ClienteDestro);
            logoAndUser.setSpacingAfter(13);
            logoAndUser.setWidthPercentage(95);
            document.add(logoAndUser);
            
            
          
            
            PdfPTable pdfPTable2 = new PdfPTable(6);
            
            pdfPTable2.addCell("ID Fattura");
            pdfPTable2.addCell("ID Ordine");
            pdfPTable2.addCell("Quantit\u00E0");
            pdfPTable2.addCell("IVA");
            pdfPTable2.addCell("Data Ordine");
            pdfPTable2.addCell("Prezzo totale");
            
   			
            
	
				
				pdfPTable2.addCell(fattura.getIdDettagliOrdine().toString());
				pdfPTable2.addCell(fattura.getIdOrdine().toString());
				pdfPTable2.addCell( fattura.getQuantita().toString() );
				pdfPTable2.addCell( formatoPrezzo.format(fattura.getIva())+"%" );
				pdfPTable2.addCell(ordine.getSpedizione().toString());
				pdfPTable2.addCell("\u20ac " + fattura.getPrezzo().toString());
				 pdfPTable2.setWidthPercentage(100);
				
				document.add(pdfPTable2);
		        
  
            document.close();
        }
        catch (DocumentException de) {
            throw new IOException(de.getMessage());
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
