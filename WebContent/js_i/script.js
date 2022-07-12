const hamburger = document.querySelector(".hamburger");
const navMenu = document.querySelector(".nav-menu");

hamburger.addEventListener("click", () => {
    hamburger.classList.toggle("active");
    navMenu.classList.toggle("active");
})

document.querySelectorAll(".nav-link").forEach(n => n.addEventListener
    ("click", () => {
        hamburger.classList.remove("active");
        navMenu.classList.remove("active");
    }))
    
    
const myFunction = () =>{
	
    const searchbox = document.getElementById("myInput").value.toUpperCase();
    const storeitems = document.getElementById("product-list");
    const product = document.querySelectorAll(".product");
    const li = document.getElementsByTagName("h3");
    
    
    for (let i = 0; i < li.length; i++) {
        let match = product[i].getElementsByTagName('h3')[0];
        if(match)
        {
        		txtValue = match.textContent || match.innerHTML;
        		
        if (txtValue.toUpperCase().indexOf(searchbox) > -1) {
            product[i].style.display = "";
        } else {
            product[i].style.display = "none";
        	}
        }
    }
}

