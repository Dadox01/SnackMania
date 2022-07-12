<%@ page language="java" import="java.util.*" import="bean.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ServletContext product =getServletContext();
    ProdottoBean prodotto =(ProdottoBean) product.getAttribute("prodotto");
  
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Info Prodotto</title>
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
          <h2 class = "product-title"><%= prodotto.getNome() %></h2>

          <div class = "product-price">
            <p class = "new-price">Prezzo: <span><%= prodotto.getPrezzo() %>€</span></p>
            <p class = "new-price">Quantità: <span><%= prodotto.getQuantita() %></span></p>
          </div>

          <div class = "product-detail">
            <h2><%= prodotto.getDescrizione() %></h2>
       
          </div>

          <div class = "purchase-info">
            
            <button type = "button" class = "btn" onclick="sum(<%=prodotto.getIdProdotto()%>)">
              Aggiungi al Carrello <i class = "fas fa-shopping-cart"></i>
            </button>
          </div>

          <div class = "social-links">
            <p>Condividi su: </p>
            <a href = "#">
              <i class = "fab fa-facebook-f"></i>
            </a>
            <a href = "#">
              <i class = "fab fa-twitter"></i>
            </a>
            <a href = "#">
              <i class = "fab fa-instagram"></i>
            </a>
            <a href = "#">
              <i class = "fab fa-whatsapp"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
	
	
	<%@ include file="recensioni.jsp" %>
	
    <script src="infoCode/script.js"></script>
    <%@ include file="footer.jsp" %>
  </body>
</html>