<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Enchères</title>
</head>
<body>
	<h2>Mon profil</h2>
	<p style="color: red;">${errorString}</p>

	<form method="POST" action="encheres/servlet/ServletSinscrire">
		<table border="0">
			<tr>
				<td>Pseudo :</td>
				<td><input type="text" name="pseudo"
					value="${utilisateur.pseudo}" /></td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td><input type="text" name="prénom"
					value="${utilisateur.prenom}" /></td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td><input type="text" name="nom" value="${utilisateur.nom}" /></td>
			</tr>
			<tr>
				<td>Email : :</td>
				<td><input type="text" name="email"
					value="${utilisateur.email}" /></td>
			</tr>
			<tr>
				<td>Téléphone :</td>
				<td><input type="text" name="telephone"
					value="${utilisateur.telephone}" /></td>
			</tr>
			<tr>
				<td>Rue :</td>
				<td><input type="text" name="rue" value="${utilisateur.rue}" /></td>
			</tr>
			<tr>
				<td>Code postal :</td>
				<td><input type="text" name="codePostal"
					value="${utilisateur.codePostal}" /></td>
			</tr>
			<tr>
				<td>Ville :</td>
				<td><input type="text" name="ville"
					value="${utilisateur.ville}" /></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><input type="text" name="motDePasse"
					value="${utilisateur.motDePasse}" /></td>
			</tr>
			<tr>
				<td>Confirmation :</td>
				<td><input type="text" name="motDePasse"
					value="${utilisateur.motdePasse}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Création" /> 
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="Annuler" /> 
			</tr>
</body>
</html>