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



<html lang = "it">
<head>
    <title>CatalogoAdmin snackmania</title>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <script src="js_i/removejs.js"></script>
     <link rel="stylesheet" type="text/css" href="code_i/add.css">
</head>


<body>

<%@ include file="header.jsp" %>

<button type="button" id="bottoneadd"  onclick="add()">Aggiungi Prodotto</button>  

     <h1 class ="title"> Catalogo </h1>

<div class="wrapper" id="Aggiungi">
    <div id="survey_options" >
   
        <h1>Aggiungi Prodotto</h1>
          
   <form action="AggiungiProdotto" method="post" ENCTYPE="multipart/form-data">
      <input type="text"  	class="survey_options" id="text" size="50" placeholder="Nome" name="NomeProdotto">
      <input type="text"  	class="survey_options" size="50" id="text"  placeholder="Descrizione" name="Descrizione">
      <input type="number"  step=0.01 class="survey_options" size="50" id="number" placeholder="Prezzo" name="Prezzo">
      <input type="text"  	class="survey_options" size="50" id="text" placeholder="Peso" name="Peso">
      <input type="text"  	class="survey_options" size="50" id="text" placeholder="Marca" name="Marca">
      <input type="number"  class="survey_options" size="50" id="number"  placeholder="Quantità" name="Quantita">
      <input type="file" id="text" accept=".jpg" name="img"> 
       <input type="submit" onclick="nascondi()" id="add">
    </form>
   
   </div>
</div>

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
        
        <button type="button" id="info" onclick="modifica(<%= prod.getIdProdotto()%>)">Modifica prodotto</button>
        <br><br>
        <button type="button" id="remove" onclick="rimuoviProdotto(<%= prod.getIdProdotto()%>)">Rimuovi</button>
    </div>
	
	<% } %>
	
</div>
s	
<%@ include file="footer.jsp" %>


</body>

</html>