<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères</title>
</head>
<body>
	<jsp:include page="PageAccueil.jsp"></jsp:include>
	
	<h3>Profil</h3>

	<p style="color: red;">${errorString}</p>

	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Pseudo</th>
			<th>Nom :</th>
			<th>Prénom :</th>
			<th>Email :</th>
			<th>Téléphone :</th>
			<th>Rue :</th>
			<th>Code Postal :</th>
			<th>Ville :</th>
		</tr>
		<c:forEach utilisateur="${utilisateurlist}" var="utilisateur">
			<tr>
				<td>${utilisateur.pseudo}</td>
				<td>${utilisateur.nom}</td>
				<td>${utilisateur.prenom}</td>
				<td>${utilisateur.email}</td>
				<td>${utilisateur.telephone}</td>
				<td>${utilisateur.rue}</td>
				<td>${utilisateur.codePostal}</td>
				<td>${utilisateur.ville}</td>


				<td><a href="modifierProfil?code=${utilisateur.pseudo}">Modifier</a></td>

			</tr>
		</c:forEach>
	</table>



</body>
</html>