function rimuoviProdotto(idprodotto){
	$.ajax({ //GET categorie
        type: 'GET', //tipo POST, GET
        url: '/SnackMania/remove', //metto la servlet
        data: { id: idprodotto }, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
            alert("prodotto rimosso con successo");
            $.get("/SnackMania/Catalogo"),
            window.location.reload();
        }
    });
}

function add(){
    document.getElementById("Aggiungi").style.display = "block";
}

function nascondi(){
    document.getElementById("Aggiungi").style.display = "none";
    $.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/AggiungiProdotto', //metto la servlet
        data: {}, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
            alert("Prodotto aggiunto con successo");
            $.get("/SnackMania/Catalogo"),
            window.location.reload();
	}

    });
}

function sum(idprodotto){
	$.ajax({ //GET categorie
        type: 'GET', //tipo POST, GET
        url: '/SnackMania/addCart', //metto la servlet
        data: { id: idprodotto }, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
        	window.location.reload();	
        }
    });
}


function modifica(idProdotto){
    $.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/getProdotto', //metto la servlet
        data: {id: idProdotto}, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
        	$.get("/SnackMania/recensioni"),
        	window.location = 'http://localhost:8080/SnackMania/modProdotto.jsp';
	}

    });
}

function applica(){
	
    $.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/modificaProdotto', //metto la servlet
        data: {}, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
        	alert("Prodotto modificato con successo");
        	window.location = 'http://localhost:8080/SnackMania/menu.jsp',
            window.location.reload();
	}
    });
}

