<%@ page language="java" import="java.util.*" import="bean.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ServletContext product2 =getServletContext();
    ProdottoBean prodotto2 =(ProdottoBean) product2.getAttribute("prodotto");
    
    final Integer id = prodotto2.getIdProdotto();
   
    ArrayList<RecensioneBean> recensioni =(ArrayList<RecensioneBean>) session.getAttribute("recensioni");
    if(recensioni == null){
    	response.sendRedirect("/SnackMania/recensioni");
        return;
    }
    

  
%>
<!DOCTYPE html>
<head>
   <meta charset= "UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <link rel="stylesheet" href="recensioni/style.css">

</head>
<body>

<div class="container5">


<div class="slide-container active">


   <div class="slide">
         <i class="fa fa-quotes icon"></i>
<form>
         <div class="user">

               <img src="recensioni/icona-profilo-utente.jpg">

               <div class="user-info">

                  <h3><input type="text" placeholder="Nome" id="nome" name="nome"></h3>

               </div>

         </div>
         <p class="text"><input type="text" placeholder="Recensione" id="recensione" name="recensione"></p>
         <input type="submit" onclick="invia(<%= id %>)" value="INVIA">
</form> 
   </div>
  
   
</div>


<% Iterator<RecensioneBean> recensione = recensioni.iterator();
   
   if(recensione == null)
   {
	   RecensioneBean review = new RecensioneBean();
	   review.setNome("null");
	   review.setTesto("null");
   }
   else{
	   while(recensione.hasNext()){
			RecensioneBean review = recensione.next();
			if(review.getIdProdotto() == prodotto2.getIdProdotto())
			{
 
    %>
   <div class="slide-container">
   
   
      
         <div class="slide">
               <i class="fa fa-quotes icon"></i>
               <div class="user">

                     <img src="recensioni/icona-profilo-utente.jpg">

                     <div class="user-info">

                        <h3><%= review.getNome()%></h3>


                     </div>

               </div>
               <p class="text"><%= review.getTesto()%></p>
         </div>
         
   </div>

<%  } } } %>

	   <div id="next" class="fa-solid fa-arrow-right" onclick="next()"></div>
   <div id="prev" class="fa-solid fa-arrow-left" onclick = "prev()"></div>

</div>
<br>
<br>

<script>

   let slides = document.querySelectorAll('.slide-container');
   let index = 0;

   function next(){
      slides[index].classList.remove('active');
      index = (index + 1) % slides.length;
      slides[index].classList.add('active');
   }

   function prev(){
      slides[index].classList.remove('active');
      index = (index - 1 +  slides.length) % slides.length;
      slides[index].classList.add('active');
   }

</script>
<script src="js_i/info.js"></script>
</body>
</html>
