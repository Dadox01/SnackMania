function updateProfilo(){
	$.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/update', //metto la servlet
        data: {}, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
            alert("aggiornamento del profilo avvenuto con successo");
            $.get("/SnackMania/profile"),
            window.location.reload();
        }
    });
}

function updatePass(){
	$.ajax({ //GET categorie
        type: 'POST', //tipo POST, GET
        url: '/SnackMania/updatePass', //metto la servlet
        data: {}, //metto i campi che devo mandare tramite la richiesta
        complete: function (response) {
            alert("aggiornamento del profilo avvenuto con successo");
            $.get("/SnackMania/profile"),
            window.location.reload();
        }
    });
}
