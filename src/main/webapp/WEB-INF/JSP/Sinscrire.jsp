<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="textcharset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/Sinscrire.css">
<title>Eni-Enchères</title>
</head>
<body>

	<div id="logo">
		<jsp:include page="lienLogo.jsp" />
	</div>
	<h1>Eni-Enchères</h1>
	<h2>Mon profil</h2>

	<p style="color: red;">${errorString}</p>
	<table="0">
		<form method="POST"
			action="<%=request.getContextPath()%>/ServletSinscrire"
			id="register-form">

			<tr id="pseudo-block" class="form-block form-text-block">
				<td>Pseudo :</td>
				<td><input type="text" name="pseudo"
					value="${utilisateur.pseudo}" /></td>
			</tr>
			<tr id="nom-block" class="form-block form-text-block">
				<td>Nom :</td>
				<td><input type="text" name="nom" value="${utilisateur.nom}" /></td>
			</tr>

			<tr id="prenom-block" class="form-block form-text-block">
				<td>Prénom :</td>
				<td><input type="text" name="prenom"
					value="${utilisateur.prenom}" /></td>
			</tr>
		<tr id="email-block" class="form-block form-text-block">
			<td>Email :</td>
			<td><input type="text" name="email" value="${utilisateur.email}" /></td>
		</tr>
		<tr id="tel-block" class="form-block form-text-block">
			<td>Téléphone :</td>
			<td><input type="text" name="telephone"
				value="${utilisateur.telephone}" /></td>
		</tr>
		<tr id="rue-block" class="form-block form-text-block">
			<td>Rue :</td>
			<td><input type="text" name="rue" value="${utilisateur.rue}" /></td>
		</tr>
		<tr id="cpo-block" class="form-block form-text-block">
			<td>Code postal :</td>
			<td><input type="text" name="codePostal"
				value="${utilisateur.codePostal}" /></td>
		</tr>
		<tr id="ville-block" class="form-block form-text-block">
			<td>Ville :</td>
			<td><input type="text" name="ville" value="${utilisateur.ville}" /></td>
		</tr>
		<tr id="mdp-block" class="form-block form-text-block">
			<td>Mot de passe :</td>
			<td><input type="password" name="motDePasse"
				value="${utilisateur.motDePasse}" /></td>
		</tr>
		<tr id="confirm-block" class="form-block form-text-block">
			<td>Confirmation :</td>
			<td><input type="password" name="motDePasseConf"
				value="${utilisateur.motdePasse}" /></td>
		</tr>


		<input type="submit" value="Créer un compte" id="creation-btn">
		<a href="/ServletPageAccueil" target="_blank"> </a>

		<button id="cancel-btn">
			<a href="http://localhost:8080/encheres/ServletPageAccueil">Annuler</a>
		</button>



		</form>
	</table>
</body>
</html>