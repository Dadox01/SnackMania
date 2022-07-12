<%@ page language="java" import="java.util.*" import="bean.*" import="model.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String email = (String) session.getAttribute("email");
	if(email == null)
	{
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}
	
	ArrayList<OrdineBean> ordini = new ArrayList<OrdineBean>();
	
	ordini = (ArrayList<OrdineBean>) session.getAttribute("ordini");
	
	if(ordini == null)
	{
		response.sendRedirect(request.getContextPath()+"/menu.jsp");
		return;
	}

	
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Responsive HTML Table</title>
    <link rel="stylesheet" href="code/ordini.css">
</head>
<body>

<%@ include file="header.jsp" %>
<br>
<br>
<div class="table_responsive">
    <table id="table">
      <thead id="thead">
        <tr>
          <th>ID</th>
          <th>Descrizione</th>
          <th>Destinazione</th>
          <th>Prezzo</th>
        </tr>
      </thead>
     
      <tbody id="tbody">
   <% 
       Iterator<OrdineBean> order = ordini.iterator();
     
		while(order.hasNext()){
		OrdineBean prod = order.next();
	
    %>
        <tr>
          <td>
          <a href="fattura?idOrdine=<%= prod.getIdOrdine() %>" style = "color: black"><%= prod.getIdOrdine() %> </a>
         
          </td>
          <td><%= prod.getDescrizione() %></td>
          <td><%= prod.getDestinazione() %></td>
          <td><%= prod.getCosto() %> €</td>
        </tr>
      </tbody>
        <% } %>
    </table>
  
</div>

<div id ="div" >

</div>

<%@ include file="footer.jsp" %>

</body>


</html>