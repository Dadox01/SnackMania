<!DOCTYPE html>
<%@ page language="java" import="java.util.*" import="bean.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	

	String nome = (String) session.getAttribute("Nome");
	String cognome = (String) session.getAttribute("Cognome");
	String mail = (String) session.getAttribute("email");
	String telefono = (String) session.getAttribute("telefono");

%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Account Settings</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="Puser/style.css">
</head>

<body>

<%@ include file="header.jsp" %>

	<section class="py-5 my-5">
		<div class="container">
		
			<h1 class="mb-5">Profilo</h1>
			<div class="bg-white shadow rounded-lg d-block d-sm-flex">
			
				<div class="profile-tab-nav border-right">
					<div class="p-4">
						<div class="img-circle text-center mb-3">
							<img src="Puser/user2.jpg" alt="Image" class="shadow">
						</div>
						<h4 class="text-center"><%= nome %> <%= cognome %></h4>
					</div>
					<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a  class="nav-link" id="account-tab"  href="menu.jsp" role="tab" aria-controls="account" aria-selected="false">
							<i class="fa fa-home text-center mr-1"></i> 
							Home
						</a>
					</div>
				</div>
				<div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
				<form action="update" method="post" >
					<div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
						<h3 class="mb-4">Impostazioni Profilo</h3>
						
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Nome</label>
								  		<input type="text" class="form-control" value="<%= nome  %>" required name="Nome" id="nome">	
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Cognome</label>
								  	<input type="text" class="form-control" value="<%= cognome  %> " required name="Cognome" id="cognome">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Email</label>
								  	<input type="text" class="form-control" value="<%= mail  %>" required name="Email" id="mail">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Numero di Telefono</label>
								  	<input type="text" class="form-control" value="<%= telefono  %>" name="Telefono">
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary" onclick = "updateProfilo()">Aggiorna Profilo</button>
						</div>
					</div>
				</form>
				
					
		<form action="updatePass" method="post" >
					<br>
						<h3 class="mb-4">Impostazioni Password</h3>
						<div class="row">
							<div class="col-md-6">
							
								<div class="form-group">
								  	<label>Vecchia password</label>
								  	<input type="password" class="form-control"  id="old" name="PasswordOld">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Nuova password</label>
								  	<input type="password" class="form-control"  name="PasswordN">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Conferma nuova password</label>
								  	<input type="password" class="form-control"  name="Password2">
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary" onclick = "updatePass()">Aggiorna Password</button>
						</div>
		  </form>
					
					
				</div>
			</div>
		</div>
	</section>
	
<%@ include file="footer.jsp" %>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="Puser/jquery.min.js"></script>
	<script src="Puser/profilo.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>