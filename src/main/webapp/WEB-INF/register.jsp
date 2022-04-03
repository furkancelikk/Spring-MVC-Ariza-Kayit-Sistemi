<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 405fu
  Date: 8.03.2022
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Kaydol</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<img class="wave" src="resources/img/wave.png">
	<div class="container">
		<div class="img">
		
		</div>
		<div class="login-content">
			<form action="index.html">
				<img src="resources/img/avatar.svg">
				<h2 class="title">Kaydol!</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-userAlpi"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Kullanıcı Adı</h5>
           		   		<input type="text" class="input">
           		   </div>
           		   
           		</div>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-userAlpi"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>İsim</h5>
           		   		<input type="text" class="input">
           		   </div>
           		   
           		</div>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-userAlpi"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Soyisim</h5>
           		   		<input type="text" class="input">
           		   </div>
           		   
           		</div>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-userAlpi"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Email</h5>
           		   		<input type="text" class="input">
           		   </div>
           		   
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Şifre</h5>
           		    	<input type="password" class="input">
            	   </div>
            	</div>
            	
            
			<input type="submit" class="btn"  value="Kayıt Ol">
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
