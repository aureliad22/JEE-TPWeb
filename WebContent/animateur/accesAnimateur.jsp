<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/head.jsp"%>
   <div id="titre">
        <h1>TP Web - Accès Animateur</h1>
    </div>
<%@include file="/navigation.jsp" %>       
    <div id="content">
        <form action="" method="post">
            <label for="login"> Identifiant : </label>
            <input type="text" name="login" id="login" /> 
            <br>
            <label for="password">Mot de Passe : </label>
            <input type="password" name="password" id="password" /> 
            <br>
            <input type="submit" name="Se connecter" value="Se connecter" onsubmit="return connexionAnim();"/>
        </form>
    </div>
<%@include file="/footer.jsp"%>