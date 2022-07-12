'use strict';

// all initial elements
const decrementBtn = document.querySelectorAll('#decrement');
const quantityElem = document.querySelectorAll('#quantity');
const incrementBtn = document.querySelectorAll('#increment');
const priceElem = document.querySelectorAll('#price');
const subtotalElem = document.querySelector('#subtotal');
const taxElem = document.querySelector('#tax');
let totalElem = document.querySelector('#total');
let increment = 0;
let decrement = 0;
//total 
totalCalc();

//function: for delete Element
function removeElement(idprodotto){
	$.ajax({ //GET categorie
        type: 'GET', //tipo POST, GET
        url: '/SnackMania/removeCart', //metto la servlet
        data: { id: idprodotto }, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
        	 window.location.reload();
        	 window.reload();
        }
    });
}

//function: for calculating total amount of product price
function totalCalc () {
	
  // declare all initial variable
  const tax = 22/100;
  let subtotal = 0;
  let totalTax = 0;
  let total = 0;
  
  
  // loop: for calculating `subtotal` value from every single product
  for (let i = 0; i < quantityElem.length; i++) {
	  
    subtotal += Number(quantityElem[i].textContent) * Number(priceElem[i].textContent);

  }

  // show the `subtotal` variable value on `subtotalElem` element
  subtotalElem.textContent = subtotal.toFixed(2);

  // calculating the `totalTax`
  totalTax = subtotal * tax;

  // show the `totalTax` on `taxElem` element
  taxElem.textContent = totalTax.toFixed(2);

  // calcualting the `total`
  total = subtotal + totalTax;

  // show the `total` variable value on `totalElem` & `payAmountBtn` element
  totalElem.textContent = total.toFixed(2);    
}

function pay(){	
	let indirizzo = document.getElementById('indirizzo');
	$.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/pagamento', //metto la servlet
        data: {totale: totalElem.textContent, adress: indirizzo.value.trim()},//metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
         alert("Prodotti acquistati con successo! Ben fatto");
         window.location = 'http://localhost:8080/SnackMania/menu.jsp';

        }
    });
}


// loop: for add event on multiple `increment` & `decrement` button

for (let i = 0; i < incrementBtn.length; i++) {
	

	incrementBtn[i].addEventListener('click', function () {

    // collect the value of `quantity` textContent,
    // based on clicked `increment` button sibling.
     increment = Number(this.previousElementSibling.textContent);

    // plus `increment` variable value by 1
    increment++;

    // show the `increment` variable value on `quantity` element
    // based on clicked `increment` button sibling.
    this.previousElementSibling.textContent = increment;
    
  
    totalCalc();
    

  });


  decrementBtn[i].addEventListener('click', function () {

    // collect the value of `quantity` textContent,
    // based on clicked `decrement` button sibling.
     decrement = Number(this.nextElementSibling.textContent);

    // minus `decrement` variable value by 1 based on condition
    decrement <= 1 ? 1 : decrement--;

    // show the `decrement` variable value on `quantity` element
    // based on clicked `decrement` button sibling.
    this.nextElementSibling.textContent = decrement;

    totalCalc();
    

  });

}




