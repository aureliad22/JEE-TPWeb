<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="navigation">
	<a href="<%request.getContextPath();%>/TPWeb/index.jsp">Accueil</a> 
	<a href="<%request.getContextPath();%>/TPWeb/Formations">Liste des formations</a> 
	<a href="<%request.getContextPath();%>/TPWeb/animateur/accesAnimateur.jsp">Accès animateur</a> 
	<a href="<%request.getContextPath();%>/TPWeb/stagiaire/accesStagiaire.jsp">Accès stagiaire</a>

	<form name="formRecherche" action="http://www.google.fr/search"
		target="_blank" method="get">
		<input type="hidden" name="hl" value="fr" /> 
		<input type="text" id="q" name="q" placeholder="Entrez votre recherche" /> 
		<input type="submit" name="rechercher" value="rechercher" />
	</form>
</div>