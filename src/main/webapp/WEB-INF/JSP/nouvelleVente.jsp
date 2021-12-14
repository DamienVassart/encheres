<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- Author: Damien Vassart -->
<head>
<meta charset="UTF-8">
<title>Nouvelle Vente</title>
</head>
<body>
	<h1>Nouvelle Vente</h1>
	<form action="<%= request.getContextPath() %>/ServletAjouterVente" method="post" id="formulaire-vente">
		<label for="nom_article">Article</label>
		<input type="text" name="nom_article" id="nom_article" required>
		
		<label for="description">Description</label>
		<textarea name="description" id="description" required></textarea>
		
		<label for="categorie">Catégorie</label>
		<select name="categorie" id="categorie" required>
			<option value="1">Ameublement</option>
			<option value="2">Informatique</option>
			<option value="3">Sport et Loisirs</option>
			<option value="4">Vêtements</option>
		</select>
		
		<label for="prix_initial">Mise à prix</label>
		<input type="number" name="prix_initial" id="prix_initial" required>
		
		<label for="date_debut_enchere">Début de l'enchère</label>
		<input type="date" name="date_debut_enchere" id="date_debut_enchere" required>
		
		<label for="date_fin_enchere">Fin de l'enchère</label>
		<input type="date" name="date_fin_enchere" id="date_fin_enchere" required>
		
		<fieldset id="retrait">
			<legend>Retrait</legend>
			
			<label for="rue">Rue</label>
			<input type="text" name="rue" id="rue" value="" required>
			
			<label for="code_postal">Code postal</label>
			<input type="text" name="code_postal" id="code_postal" value="" required>
			
			<label for="ville">Ville</label>
			<input type="text" name="ville" id="ville" value="" required>
		</fieldset>
		
		<input type="submit" value="Enregistrer">
		<button><a href="<%= request.getContextPath() %>/JSP/PageAccueil.jsp">Annuler</a></button>
	</form>
</body>
</html>