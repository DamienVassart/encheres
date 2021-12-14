<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.messages.LecteurMessage" %>
<%@ page import="fr.eni.encheres.bo.Article"  %>
<!DOCTYPE html>
<html>
<!-- Author: Damien Vassart -->
<head>
<meta charset="UTF-8">
<title>Modifier une Vente</title>
</head>
<body>
	<h1>Modifier une Vente</h1>
	<%
		Article article = (Article) request.getAttribute("article");
	%>
	
	<form action="<%= request.getContextPath() %>/ServletModifierVente" method="post" id="formulaire-vente">
		<label for="nom_article">Article</label>
		<input type="text" name="nom_article" id="nom_article" value="<%=article.getNomArticle() %>" required>
		
		<label for="description">Description</label>
		<textarea name="description" id="description" required>
			<%=article.getDescription() %>
		</textarea>
		
		<label for="categorie">Catégorie</label>
		<select name="categorie" id="categorie" required>
			<option value="1">Ameublement</option>
			<option value="2">Informatique</option>
			<option value="3">Sport et Loisirs</option>
			<option value="4">Vêtements</option>
		</select>
		
		<label for="prix_initial">Mise à prix</label>
		<input type="number" name="prix_initial" id="prix_initial" value="<%=article.getMiseAPrix() %>" required>
		
		<label for="date_debut_enchere">Début de l'enchère</label>
		<input type="date" name="date_debut_enchere" id="date_debut_enchere" value="<%=article.getDateDebutEncheres() %>" required>
		
		<label for="date_fin_enchere">Fin de l'enchère</label>
		<input type="date" name="date_fin_enchere" id="date_fin_enchere" value="<%=article.getDateFinEncheres() %>" required>
		
		<fieldset id="retrait">
			<legend>Retrait</legend>
			
			<label for="rue">Rue</label>
			<input type="text" name="rue" id="rue" value="<%=article.getRetrait().getRue() %>" required>
			
			<label for="code_postal">Code postal</label>
			<input type="text" name="code_postal" id="code_postal" value="<%=article.getRetrait().getCodePostal() %>" required>
			
			<label for="ville">Ville</label>
			<input type="text" name="ville" id="ville" value="<%=article.getRetrait().getVille() %>" required>
		</fieldset>
		
		<input type="submit" value="Enregistrer">
		<button><a href="<%= request.getContextPath() %>/JSP/PageAccueil.jsp">Annuler</a></button>
	</form>
</body>
</html>