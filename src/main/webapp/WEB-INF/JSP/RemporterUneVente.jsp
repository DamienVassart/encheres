<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère remportée</title>
</head>
<body>
	<strong>L'enchère a été remportée par : </strong>
		<input type="text"name="Utilisateur" value="${pseudoGagnant}" readonly="readonly">
					
	<br><br><strong>Nom de l'article : </strong> ${nomArticle}
	<br><br><strong>Référence de l'article : </strong> ${noArticle}
	<%-- Est-ce que l'on rajoute des images ?--%>
	<%--<br><br> <img src="./lib/image.jpg" class="Lib" alt="nom de l'image">--%>
	
	<br><br><strong> Description : </strong> ${description} 
	<br><strong>Meilleure offre: ${prixVente} par : </strong>
		<a href="Utilisateur?pseudo=${pseudoGagnant}">${pseudoGagnant}</a>
	
	<br><br><strong> Mise à prix : </strong> ${miseAPrix } 
	<br><strong> Fin de l'enchere : </strong>${DateFinEncheres} 
	<br><br><strong>Retrait : </strong>
			
			<div class="row">
				<div class="col-md-auto">
						${RueRetrait}
					<br> ${CodePostalRetrait} ${VilleRetrait}
				</div>
			</div>
			
	<br><strong> Vendeur : </strong>
	<a href="Utilisateur?pseudo=${UtilisateurVendeur}">${UtilisateurVendeur}<br /></a>
	<br>
	
	
</body>
</html>