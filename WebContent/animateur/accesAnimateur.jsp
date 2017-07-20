<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/head.jsp"%>
   <div id="titre">
        <h1>TP Web - Accès Animateur</h1>
    </div>
<%@include file="/navigation.jsp" %>       
    <div id="content">
        <form class="connexion" action="/AccesAnimateur" method="post">
        <div class="bloc_identifiant">
            <label for="login">Identifiant</label>
            <input class="champtexte" type="text" id="login" name="login" />
        </div>
        <div class="bloc_motdepasse">
            <label for="motdepasse">Mot de passe</label>
            <input class="champtexte" type="text"  id="motdepasse" name="motdepasse" />
        </div>
        <div class="bloc_connexion">
            <input type="submit" id="seconnecter" value="se connecter" />
        </div>
        </form>
    </div>
<%@include file="/footer.jsp"%>