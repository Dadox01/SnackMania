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

<html>

<link rel="icon" type=”image/ico” href="code_i/favicon.ico">
<body>

<%@ include file="header.jsp" %>


<div class="container" id="product-list">
    
    <% Iterator<ProdottoBean> prodotto = article.iterator();
       int i = 0;
		while(prodotto.hasNext() && i < 6){
		ProdottoBean prod = prodotto.next();
		i++;
		
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

<div class="other">
 	
        <a  href ="catalogo.jsp">Vai al catalogo</a>
      
</div>


<%@ include file="footer.jsp" %>

  
</body>
</html>