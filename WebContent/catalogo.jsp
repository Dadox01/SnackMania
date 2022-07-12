<%@ page language="java" import="java.util.*" import="bean.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ServletContext cxt=getServletContext();
    ArrayList<ProdottoBean> article =(ArrayList<ProdottoBean>) cxt.getAttribute("articoli");
    if(article==null)
    {
        response.sendRedirect("/SnackMania/Catalogo");
        return;
    }
    
    
%>
<html lang = "it">
<head>
    <title>Catalogo snackmania</title>
</head>

<body>

<%@ include file="header.jsp" %>


     <h1 class ="title"> Catalogo </h1>
     
<div class="container" id="product-list">
    
    <% Iterator<ProdottoBean> prodotto = article.iterator();
     
		while(prodotto.hasNext()){
		ProdottoBean prod = prodotto.next();
		
    %>
    
      <div class="card product">
        <img src="ImgC/<%=prod.getIdProdotto()%>.jpg" >
        <h3>
          <%= prod.getNome() %>
        	</h3>
        <p>
            <%= prod.getDescrizione() %>
        </p>
        
        <button type="button" id="info" onclick="infoProdotto(<%=prod.getIdProdotto()%>)">Maggiori Dettagli</button>
        <br>
        <button type="button" id="remove" onclick="sum(<%=prod.getIdProdotto()%>)">Aggiungi al carrello</button>
    </div>
	
	<% } %>
</div>
	
<%@ include file="footer.jsp" %>

	
</body>
</html>