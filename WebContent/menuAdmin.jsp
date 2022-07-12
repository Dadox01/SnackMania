<%@ page language="java" import="java.util.*" import="bean.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ServletContext cxt=getServletContext();
    ArrayList<ProdottoBean> article =(ArrayList<ProdottoBean>) cxt.getAttribute("articoli");
    if(article==null)
    {
        response.sendRedirect("/SnackMania/Catalogo");
        return;
    }
    
    Boolean Admin = (Boolean) session.getAttribute("adminRoles");
    if(Admin == null || Admin == false)
    {
    	response.sendRedirect(request.getContextPath()+"/menu.jsp");
    	return;
    }
   
%>

<html>
<body>

<%@ include file="header.jsp" %>

<div class="container" id="product-list">
    
    <% Iterator<ProdottoBean> prodotto = article.iterator();
    int contatore = 0;
     
		while(prodotto.hasNext() && contatore < 6){
		ProdottoBean prod = prodotto.next();
		contatore++;
	
    %>
    
      <div class="card product">
        <img src="ImgC/<%=prod.getIdProdotto()%>.jpg" >
        <h3>
          <%= prod.getNome() %>
        	</h3>
        <p>
            <%= prod.getDescrizione() %>
        </p>
        
        <button type="button" id="info" onclick="modifica(<%= prod.getIdProdotto()%>)">Modifica prodotto</button>
        <br><br>
        <button type="button" id="remove" onclick="rimuoviProdotto(<%= prod.getIdProdotto()%>)">Rimuovi</button>
    </div>
	
	<% } %>
	
</div>

<div class="other">
 	
        <a  href ="catalogoA.jsp">Vai al catalogo</a>
      
</div>


<%@ include file="footer.jsp" %>

</body>
</html>