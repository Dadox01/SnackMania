
function infoProdotto(idprodotto){
	$.ajax({ //GET categorie
        type: 'GET', //tipo POST, GET
        url: '/SnackMania/infoProduct', //metto la servlet
        data: { id: idprodotto }, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
        	$.get("/SnackMania/recensioni"),
        	window.location = 'http://localhost:8080/SnackMania/infoProdotto.jsp';
        }
    });	
}

function invia(idProdotto){
	
	var nome = document.getElementById("nome").value;
	var recensione = document.getElementById("recensione").value;
	
	$.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/setRecensioni', //metto la servlet
        data: { id: idProdotto, name: nome, rec : recensione}, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
        	$.get("/SnackMania/recensioni"),
        	window.location = 'http://localhost:8080/SnackMania/infoProdotto.jsp';	
        }
    });
}


function rimuovi(idProdotto){
	$.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/rimuoviRecensioni', //metto la servlet
        data: { id: idProdotto}, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
        	$.get("/SnackMania/recensioni"),
        	window.location = 'http://localhost:8080/SnackMania/infoProdotto.jsp';	
        }
    });
}