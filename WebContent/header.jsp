<%@ page language="java" import="java.util.*" import="bean.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String userName = (String) session.getAttribute("Nome");
	Integer count = (Integer) session.getAttribute("count");

	if(count == null || count == 0)
	{
		count = 0;
	}

	if(userName == null)
	{
		userName = "Accedi";
	}
	
%>


<head>

    <meta charset = "UTF -8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="code_i/menu.css">
    <script src="https://kit.fontawesome.com/030da03578.js" ></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href ="code_i/catalogo.css">
    <link rel="stylesheet" href ="code_i/header.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="icon" href="code_i/favicon.ico" type="img/ico">
	
</head>

<body>
<header>

<nav class="navbar">
    <a href="menu.jsp" class="nav-branding">
        <img src="logo/rsz_logo.jpg">   
    </a>

    <div class="boxContainer">
        <table class="elementsContainer">
            <tr>
                <td>
                    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Cerca nel sito..." class="search">
                </td>
                <td class="icona_ricerca">
                    <a href="#" ><i class="material-icons">search</i>
                    </a>
                </td>
            </tr>
        </table>
    </div>
    
    <ul class="nav-menu">
        <li class="nav-item">
            <a href="menu.jsp" class="nav-link"><i class="fa-solid fa-house-chimney"></i></a>
     </li>
     
    
     <li class = "dropdown">
            <button class="dropbtn" id="dropbtn" onclick="window.location.href='login.jsp'"><i class="fa-solid fa-user"></i>&nbsp&nbsp&nbsp<%= userName %> </button>    
            <div class="dropdown-content">
            <a href="login.jsp"><i class="fa-solid fa-circle-user"></i></a>
            <a href="getOrdini"><i class="fa-solid fa-truck-fast"></i></a>
            <a href="/SnackMania/Logout"><i class="fa-solid fa-arrow-right-from-bracket"></i></a>
            </div>
      </li>
        <li class="nav-item">
            <a href="shop.jsp" class="nav-link" id="carrello"><i class="fa-solid fa-cart-shopping">&nbsp&nbsp&nbsp<span class="badge" id="counter"><%= count %></span></i></a>
        </li>
        <li class="nav-item">
            <a href="contatti.jsp" class="nav-link"><i class="fa-solid fa-circle-info"></i></a>
        </li>
    </ul>
    <div class="hamburger">
        <span class="bar"></span>
        <span class="bar"></span>
        <span class="bar"></span>
        <span class="bar"></span>
    </div>
    
    </nav>
    
    
</header>

    <script src="js_i/script.js"></script>
    <script src="js_i/removejs.js"></script>
    <script src="js_i/info.js"></script>
  
</body>