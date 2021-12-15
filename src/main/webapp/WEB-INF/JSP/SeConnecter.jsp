
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Laurane Marie -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="textcharset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/SeConnecter.css">
<title>ENI-Enchères</title>
</head>
<body>
	
	<div id="logo">
		<jsp:include page="lienLogo.jsp"/>
	</div>
	
	<h1>ENI Enchères</h1>

	<h3>Connexion</h3>
	<p id="error">${errorString}</p>


	<form method="POST" action="${pagecontext.request.contextPath}/" id="login-form">

			<div id="pseudo-block" class="form-block form-text-block">
				<label for="pseudo">Identifiant: </label>
				<input type="text" name="pseudo" id="pseudo" class="login-form-field" value="${utilisateur.pseudo}" required>
			</div>
			
			<div id="mdp-block" class="form-block form-text-block">
				<label for="motDePasse">Mot de passe: </label>
				<input type="password" name="motDePasse" id="motDePasse" class="login-form-field" value="${utilisateur.motDePasse}" required>
			</div>
			
			<div id="remember-block" class="form-block">
				<label for="rememberMe">Se souvenir de moi </label>
				<input type="checkbox" name="rememberMe" id="rememberMe" class="login-form-checkbox" value="Y">
			</div>

			<input type="submit" value="Connexion" id="connect-btn">
			
			<button id="register-btn"><a href="http://localhost:8080/encheres/ServletSinscrire">Créer un compte</a></button>
	</form>

	


</body>
</html>
