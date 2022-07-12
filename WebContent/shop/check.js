
//element for the form
const form = document.getElementById('form');
const titolare = document.getElementById('titolare');
const number = document.getElementById('card-number');
const month = document.getElementById('mese');
const year = document.getElementById('anno');
const cvv = document.getElementById('cvv');
const indirizzo = document.getElementById('indirizzo');
const nome = document.getElementById('nome');
const cognome = document.getElementById('cognome');
const cap = document.getElementById('cap');

form.addEventListener('submit', e => {
	e.preventDefault();
	
	
	checkInputs();
});

function checkInputs() {
	// trim to remove the whitespaces
	let count = 0;
	const usernameValue = nome.value.trim();
	const surname = cognome.value.trim();
	const mese = month.value.trim();
	const anno = year.value.trim();
	const numeroCarta = number.value.trim();
	const nomeCarta = titolare.value.trim();
	const capValue = cap.value.trim();
	const adress = indirizzo.value.trim();
	const cvvValue = cvv.value.trim();
	
	
	if(adress === '' || adress == null) {
		setErrorFor(indirizzo, 'Campo obbligatorio');
	} else {
		count++;
		setSuccessFor(indirizzo);
	}
	
	if(usernameValue === '') {
		setErrorFor(nome, 'Campo obbligatorio');
	} else {
		count++;
		setSuccessFor(nome);
	}
	
	if(surname === '') {
		setErrorFor(cognome, 'Campo obbligatorio');
	}
	else {
		count++;
		setSuccessFor(cognome);
	}
	
	if(capValue === '') {
		setErrorFor(cap, 'Campo obbligatorio');
	} else {
		count++;
		setSuccessFor(cap);
	}
	
	if(mese === '') {
		setErrorFor(month, 'Campo obbligatorio');
	} else {
		count++;
		setSuccessFor(month);
	}
	
	if(anno === '') {
		setErrorFor(year, 'Campo obbligatorio');
	} else {
		count++;
		setSuccessFor(year);
	}
	
	if(nomeCarta === '') {
		setErrorFor(titolare, 'Campo obbligatorio');
	} else {
		count++;
		setSuccessFor(titolare);
	}
	
	if(numeroCarta === '') {
		setErrorFor(number, 'Campo obbligatorio');
	} else {
		count++;
		setSuccessFor(number);
	}
	
	
	if(cvvValue === '') {
		setErrorFor(cvv, 'Campo obbligatorio');
	} else{
		count++;
		setSuccessFor(cvv);
	}

	
	if(count == 9)
	{
		pay();
	}
}



function setSuccessFor(input) {
	const formControl = input.parentElement;
	formControl.className = 'form-control success';
}

function setErrorFor(input, message) {
	const formControl = input.parentElement;
	const small = formControl.querySelector('small');
	formControl.className = 'form-control error';
	small.innerText = message;
}