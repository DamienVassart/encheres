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
	
			Pseudo : <b>${utilisateur.pseudo}</b>
			Nom : <b>${utilisateur.nom}</b>
			Prénom : <b>${utilisateur.prenom}</b>
			Email : <b>${utilisateur.email}</b>
			Téléphone : <b>${utilisateur.telephone}</b>
			Rue : <b>${utilisateur.rue}</b>
			Code Postal : <b>${utilisateur.codePostal}</b>
			Ville : <b>${utilisateur.ville}</b>
			
    <br />


				<td><a href="modifierProfil?code=${utilisateur.pseudo}">Modifier</a></td>

			</tr>
		</c:forEach>
	</table>



</body>
</html>