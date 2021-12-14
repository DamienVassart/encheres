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

	<h2>Modifier mon profil</h2>

	<p style="color: red;">${errorString}</p>

	<c:if test="${not empty profile}">
		<form method="POST"
			action="{pageContext.request.contextPath}/ModifierMonProfil">
			<input type="hidden" name="code" value="${product.code}" />
			<table border="0">
				<tr>
					<td>Pseudo :</td>
					<td><input type="text" name="name" value="${utilisateur.pseudo}" /></td>
				</tr>
				<tr>
					<td>Prénom :</td>
					<td><input type="text" name="name" value="${utilisateur.prenom}" /></td>
				</tr>
				<tr>
					<td>Nom :</td>
					<td><input type="text" name="name" value="${utilisateur.nom}" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="name" value="${utilisateur.email}" /></td>
				</tr>
				<tr>
					<td>Téléphone :</td>
					<td><input type="text" name="name" value="${utilisateur.email}" /></td>
				</tr>
				<tr>
					<td>Rue :</td>
					<td><input type="text" name="name" value="${utilisateur.rue}" /></td>
				</tr>
				<tr>
					<td>Code Postal :</td>
					<td><input type="text" name="name" value="${utilisateur.codePostal}" /></td>
				</tr>
				<tr>
					<td>Ville :</td>
					<td><input type="text" name="name" value="${utilisateur.ville}" /></td>
				</tr>
				<tr>
					<td>Mot de passe actuel :</td>
					<td><input type="text" name="name" value="${utilisateur.motdePasse}" /></td>
				</tr>
				<tr>
					<td>Nouveau mot de passe :</td>
					<td><input type="text" name="name" value="${product.motDePasse}" /></td>
				</tr>
				<tr>
					<td>Confirmation :</td>
					<td><input type="text" name="name" value="${utilisateur.motDePasse}" /></td>
				</tr>
				<tr>
             <td colspan ="2">
                  <input type="submit" value= "Enregistrer" />
                  <input type="submit" value="Supprimer mon compte"/>
               </td>
            </tr>
			</table>
		</form>
	</c:if>

</body>
</html>