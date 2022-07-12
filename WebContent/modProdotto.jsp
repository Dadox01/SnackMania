<%@ page language="java" import="java.util.*" import="bean.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ServletContext product =getServletContext();
	ProdottoBean prodotto = (ProdottoBean) product.getAttribute("prodottoModifica");
	if(prodotto == null)
	{
		response.sendRedirect(request.getContextPath()+"/menu.jsp");
		return;
	}
	
	 Boolean Admin = (Boolean) session.getAttribute("adminRoles");
	    if(Admin == null || Admin == false)
	    {
	    	response.sendRedirect(request.getContextPath()+"/menu.jsp");
	    	return;
	    }
	    

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Modifica Prodotto</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="infoCode/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  </head>
  <%@ include file="header.jsp" %>
  <body>


    <div class = "card-wrapper">
      <div class = "card">
        <!-- card left -->
        <div class = "product-imgs">
          <div class = "img-display">
            <div class = "img-showcase">
              <img src = "ImgC/<%=prodotto.getIdProdotto()%>.jpg" alt = "shoe image">
            </div>
          </div>
        </div>
        <!-- card right -->
        <div class = "product-content">
        
<form action="modificaProdotto" method="post" ENCTYPE="multipart/form-data">
          <h2 class = "product-title"><%= prodotto.getNome() %></h2>
          <input type="text" placeholder="Nome Prodotto" name="NomeProdotto" id="nome">
          <input type="text" placeholder="Marca prodotto" name="marcaProdotto" id="marca">

          <div class = "product-price">
            <p class = "new-price">Prezzo: <span><%= prodotto.getPrezzo() %>€</span></p>
            <input type="number" step=0.01 placeholder="Prezzo" name="prezzo" id="prezzo">
            <p class = "new-price">Quantità: <span><%= prodotto.getQuantita() %></span></p>
            <input type="number" placeholder="Quantita" name="quantita" id="quantita">
             <p class = "new-price">Peso: <span><%= prodotto.getPeso() %></span></p>
           <input type="text" placeholder="Peso" name="peso" id="peso">
            
          </div>

          <div class = "product-detail">
            <h2><%= prodotto.getDescrizione() %></h2>
            <input type="text" placeholder="Descrizione prodotto" name="desc" id="desc">
          </div>
           
           <div class= "product-detail">
	            <p class = "new-price">Nuova Immagine:</p>
	           <input type="file" id="text" accept=".jpg" name="img" id="img"> 
           </div>
           
          <div class = "purchase-info">
            <button type = "submit" class = "btn" onclick="applica()">
              Applica
            </button>
          </div>
</form>
          
        </div>
      </div>
    </div>

    
    <%@ include file="recensioniAdmin.jsp" %>
    <script src="infoCode/script.js"></script>
    <script src="js_i/removejs.js"></script>
    <%@ include file="footer.jsp" %>
  </body>
</html>