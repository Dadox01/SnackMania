<%@ page language="java" import="java.util.*" import="bean.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String email = (String) session.getAttribute("email");
	if(email != null)
	{
		response.sendRedirect(request.getContextPath()+"/profilo.jsp");
		return;
	}

%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- ===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <!-- ===== CSS ===== -->
    <link rel="stylesheet" href="loginCode/style.css">
         
    <title>Login and Registration Form</title>
</head>
<body>

    
    <div class="container">
        <div class="forms">
            <div class="form login">
                <span class="title">Login</span>

                <form action="LoginUtente" method="post">
                    <div class="input-field">
                        <input type="text" id="Email" placeholder="Email" required name="Email">
                        <i class="uil uil-envelope icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="password" id="Password" class="password" placeholder="Password" required name="Password">
                        <i class="uil uil-lock icon"></i>
                        <i class="uil uil-eye-slash showHidePw"></i>
                    </div>

                    <div class="checkbox-text">
                        <div class="checkbox-content">
                            <input type="checkbox" id="logCheck">
                            <label for="logCheck" class="text">Ricordami</label>
                        </div>
                       
                    </div>

                    <div class="input-field button">
                        <input type="submit" value="Accedi">
                    </div>
                </form>

                <div class="login-signup">
                    <span class="text">Non sei registrato?
                        <a href="#" class="text signup-link">Registrati!</a>
                    </span>
                </div>
            </div>

            <!-- Registration Form -->
            <div class="form signup">
                <span class="title">Registrazione</span>

                <form action="Registrazione" method="post">
                    <div class="input-field">
                        <input type="text" placeholder="Nome" required name="Nome">
                        <i class="uil uil-user"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" placeholder="Cognome" required name="Cognome">
                        <i class="uil uil-user"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" placeholder="Email" required name="Email">
                        <i class="uil uil-envelope icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="password" class="password" placeholder="Password" required name="Password">
                        <i class="uil uil-lock icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="password" class="password" placeholder="Conferma password" required name="ConfPassword">
                        <i class="uil uil-lock icon"></i>
                        <i class="uil uil-eye-slash showHidePw"></i>
                    </div>

                    <div class="checkbox-text">
                        <div class="checkbox-content">
                            <input type="checkbox" id="sigCheck">
                            <label for="sigCheck" class="text">Ricordami</label>
                        </div>
                    </div>

                    <div class="input-field button">
                        <input type="submit" value="Registrati">
                    </div>
                </form>

                <div class="login-signup">
                    <span class="text">Sei già registrato?
                        <a href="#" class="text login-link">Accedi!</a>
                    </span>
                </div>
            </div>
        </div>
    </div>
	
	
    <script src="loginCode/script.js"></script>


</body>
</html>