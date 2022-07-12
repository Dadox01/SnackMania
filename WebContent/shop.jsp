<%@ page language="java" import="java.util.*" import="bean.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

   ArrayList<ProdottoBean> prodotti = (ArrayList<ProdottoBean>) session.getAttribute("prodottiCart");
	 if(prodotti == null){
		response.sendRedirect(request.getContextPath()+"/menu.jsp");
	    return;
	}
	 else if(prodotti.size() == 0){
		response.sendRedirect("/SnackMania/Catalogo");
        return;
	}

    
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Carrello</title>

  <!--
    - custom css link
  -->
  <link rel="stylesheet" href="shop/style.css">

  <!--
    - google font link
  -->
  <link
    href="https://fonts.googleapis.com/css?family=Source+Sans+3:200,300,regular,500,600,700,800,900,200italic,300italic,italic,500italic,600italic,700italic,800italic,900italic"
    rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>

<%@ include file="header.jsp" %>
<br>
<br>
  <!--
    - main container
  -->

  <main class="container_shop">
  

    <h1 class="heading">
    <i class="fa-solid fa-cart-shopping"></i>Carrello </h1>

    <div class="item-flex">

      <!--
       - checkout section
      -->
      <section class="checkout">

        <h2 class="section-heading">Dettagli di Pagamento</h2>

        <div class="payment-form">

          <div class="payment-method">

            <button class="method selected">
              <ion-icon name="card"></ion-icon>

              <span>Carta di Credito</span>

              <ion-icon class="checkmark fill" name="checkmark-circle"></ion-icon>
            </button>

          </div>

          
<form id="form" action="pagamento" method="post" class="form">

            <div class="form-control">
              <label for="cardholder-name" class="label-default">Titolare della carta</label>
              <input type="text" name="cardholder-name" id="titolare" class="input-default">
              <i class="fas fa-check-circle"></i>
			  <i class="fas fa-exclamation-circle"></i>
              <small>Error message</small>
            </div>

            <div class="form-control">
              <label for="card-number" class="label-default">Numero della carta</label>
              <input type="number" name="card-number" id="card-number" class="input-default">
              <i class="fas fa-check-circle"></i>
			  <i class="fas fa-exclamation-circle"></i>
              <small>Error message</small>
            </div>

            <div class="input-flex">

              <div class="expire-date" id="form-control">
                <label for="expire-date" class="label-default">Data di scadenza</label>

                <div class="form-control" id="input-flex">

                  <input type="number" name="month" id="mese" placeholder="MM" class="input-default" min="0" max="12">
                   <i class="fas fa-check-circle"></i>
			       <i class="fas fa-exclamation-circle"></i>
                
                    
               
                   <input type="number" name="year" id="anno" placeholder="YY" class="input-default" min="22" max="33">
                   <i class="fas fa-check-circle"></i>
			       <i class="fas fa-exclamation-circle"></i>
                    <small>Error message</small>
                   
	  				</div>
                
              </div>

              <div class="form-control">
                <label for="cvv" class="label-default">CVV</label>
                <input type="number" name="cvv" id="cvv" class="input-default">
                <i class="fas fa-check-circle"></i>
			    <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
              </div>
            </div>
			<br>
			<h2 class="section-heading">Dettagli di Spedizione</h2>
			

		<div class="input-flex" >
			<div class="form-control">
              <label for="cardholder-name" class="label-default">Indirizzo di spedizione</label>
              <input type="text"  id="indirizzo" class="input-default" name="indirizzo">
              <i class="fas fa-check-circle"></i>
			  <i class="fas fa-exclamation-circle"></i>
              <small>Error message</small>
            </div>
            
            <div class="form-control">
              <label for="cardholder-name" class="label-default">CAP</label>
              <input type="text" name="cap" id="cap" class="input-default">
              <i class="fas fa-check-circle"></i>
			  <i class="fas fa-exclamation-circle"></i>
              <small>Error message</small>
            </div>
          </div>
            
        <div class="form-control">
            
            <div id="input-flex">

              <div class="cardholder-name" id="form-control">
              <label for="cardholder-name" class="label-default">Nome</label>
              <input type="text" name="nome" id="nome" class="input-default">
              <i class="fas fa-check-circle"></i>
			  <i class="fas fa-exclamation-circle"></i>
              <small>Error message</small>
            </div>
                
			&nbsp	&nbsp	&nbsp	&nbsp
            <div class="form-control">
              <label for="cardholder-name" class="label-default">Cognome</label>
              <input type="text" name="cognome" id="cognome" class="input-default">
              <i class="fas fa-check-circle"></i>
			  <i class="fas fa-exclamation-circle"></i>
              <small>Error message</small>
            </div>
            
                </div>
         </div>
          	<button type="submit" class="btn btn-primary">Paga</button>	
   </form>
			
        </div>
		
      </section>


      <!--
        - cart section
      -->
      <section class="cart">

        <div class="cart-item-box">

          <h2 class="section-heading">Riepilogo</h2>

          <div class="product-card">
           <% Iterator<ProdottoBean> prodotto = prodotti.iterator();
            
					while(prodotto.hasNext()){
					ProdottoBean prod = prodotto.next();
					
	
			    %>

            <div class="card">
               

              <div class="img-box">
              	<img src="ImgC/<%=prod.getIdProdotto()%>.jpg"  width="80px" class="product-img" >
              </div>

              <div class="detail">

                <h4 class="product-name"><%=prod.getNome()%></h4>

                <div class="wrapper">

                  <div class="product-qty">
                    <button id="decrement">
                      <ion-icon name="remove-outline"></ion-icon>
                    </button>

                    <span id="quantity">1</span>

                    <button id="increment">
                      <ion-icon name="add-outline"></ion-icon>
                    </button>
                  </div>

                  <div class="price">
                    €<span id="price"><%=prod.getPrezzo()%></span>
                  </div>

                </div>

              </div>

              <button class="product-close-btn" onclick="removeElement(<%=prod.getIdProdotto()%>)">
                <ion-icon name="close-outline"></ion-icon>
              </button>

            </div>
				
				<% } %>
          </div>
          

        </div>

        <div class="wrapper">

          <div class="amount">

            <div class="subtotal">
              <span>Subtotale</span> <span>€ <span id="subtotal">  </span></span>
            </div>

            <div class="tax">
              <span>Tasse</span> <span>€ <span id="tax">0.10</span></span>
            </div>

            <div class="shipping">
              <span>Spedizione</span> <span>€ <span id="shipping">0.00</span></span>
            </div>

            <div class="total">
              <span>Totale</span> <span>€ <span id="total"></span></span>
            </div>

          </div>

        </div>

      </section>

    </div>

  </main>



<br>
<br>
<%@ include file="footer.jsp" %>

  <!--
    - custom js link
  -->
  <script src="shop/check.js"></script>
  <script src="shop/script.js"></script>




  <!--
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>

</html>