<%-- @auteur Dorothee Blanchard --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ENI-Encheres page d'accueil</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/PageAccueil.css">
</head>

	<body>
		<!-- this is the header at the top of the page -->
		<div id="header">
			<!-- use img for logo -->

			<div class="element1">
				<img src="${pageContext.request.contextPath}/images/recycling_yellow_green_logo_small.png" alt="logo" width="100" height="100" />
			</div>
			<!-- there is no need to close an img tag -->

			<!-- use h1 for page title --> 
			<div class="element2">
				<h1>
					Bienvenue sur ENI-Enchères
				</h1>
			</div>

			<div class="element3">
				<a href="http://localhost:8080/encheres/ServletSinscrire">S'inscrire</a><br>
				<a href="http://localhost:8080/encheres/ServletSeConnecter">Se connecter</a>
		    </div>
		</div>

		<!-- this is the main content of the page -->

		<div id="topmain">
			<div class="element4">
				<h2>
					Les objets sont nos amis
				</h2>
			</div>
			
			<div class="element5">
				<p>Nous permettons la cession d'objets de seconde main sans transaction financière:<br>
				la valeur des articles est déterminée par un système d'enchères basé sur un nombre de points. <br>
				Vous gagnez des points en vendant des objets, et vous pouvez utiliser ces points pour acquérir d'autres objets.</p>
			</div>
		</div>

		<div id="recherche">
			<div class="filtres">
				<h3>
					Filtres
				</h3>

				<input type="text" class="filtres" placeholder="Le nom de l'article contient">

			</div>

			<div class="categories">
				<h3>
					Catégories
				</h3>

				<form name="Catégories" id="form1" action="/action_page.php">
					<select name="categorie" id="categorie">
						<option value="" selected="selected">Ameublement</option>	
						<option value="" selected="selected">Informatique</option>
						<option value="" selected="selected">Sports et loisirs</option>
						<option value="" selected="selected">Vêtements</option>	
						<option value="" selected="selected">Toutes</option>		
					</select>
					  
					<input type="submit" value="Rechercher"> 
				</form>
			</div>
		</div>

		<div id="articles">
			<div class="article1">
				<img src="${pageContext.request.contextPath}/images/pcgamer.jpeg" alt="PC Gamer" width="110" height="100" />
				<a href=""><h4>PC Gamer pour travailler</h4></a>
				<p>Prix: 210 points</p>
				<p>Fin de l'enchère: 10/01/2022</p>
				<p>Vendeur: jojo44</p>
			</div>

			<div class="article2">
				<img src="${pageContext.request.contextPath}/images/rocketstove.jpeg" alt="Rocket Stove" width="100" height="100" />
				<a href=""><h4>Rocket stove pour riz et pâtes</h4></a>
				<p>Prix: 185 points</p>
				<p>Fin de l'enchère: 03/01/2022</p>
				<p>Vendeur: NineJea</p>
			</div>

			<div class="article3">
				<img src="${pageContext.request.contextPath}/images/raquette.jpeg" alt="Raquette de tennis" width="100" height="100" />
				<a href=""><h4>Raquette de tennis</h4></a>
				<p>Prix: 20 points</p>
				<p>Fin de l'enchère: 08/01/2022</p>
				<p>Vendeur: Amn44</p>
			</div>
		</div>
		
		<div id="bottomsection">
				<small>&copy; ENI ECOLE Informatique<br>
				Dernière mise a jour: décembre 2021.</small>
		</div>
	</body>